package pl.sii.website.core.common.infrastructure.repo.impl;

import java.util.Collections;
import java.util.Map;

import org.apache.sling.api.resource.ResourceResolverFactory;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import pl.sii.website.core.common.exception.SiiRuntimeException;
import pl.sii.website.core.common.infrastructure.repo.RepositoryConnection;
import pl.sii.website.core.common.infrastructure.repo.RepositoryConnectionFactory;

/**
 * The Class RepositoryConnectionFactoryImpl.
 *
 * @author Jaroslav Rassadin
 */
@Component(
		immediate = true,
		service = RepositoryConnectionFactory.class)
public class RepositoryConnectionFactoryImpl implements RepositoryConnectionFactory {

	private static final String SUBSERVICE_NAME = RepositoryConnectionFactory.class.getSimpleName();

	private static final Map<String, Object> AUTH_INFO = Collections.singletonMap(ResourceResolverFactory.SUBSERVICE, SUBSERVICE_NAME);

	@Reference
	private ResourceResolverFactory resourceResolverFactory;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public RepositoryConnection getConnection() {
		try {
			return new RepositoryConnectionImpl(this.resourceResolverFactory.getServiceResourceResolver(AUTH_INFO));

		} catch (final Exception ex) {
			throw new SiiRuntimeException(String.format("Unable to login to repository with subservice name '%s' using %s.", SUBSERVICE_NAME,
					this.resourceResolverFactory.getClass()), ex);
		}
	}

}
