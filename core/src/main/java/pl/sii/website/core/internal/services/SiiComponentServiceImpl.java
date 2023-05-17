package pl.sii.website.core.internal.services;

import org.apache.sling.api.resource.ResourceResolver;
import org.osgi.service.component.annotations.Activate;
import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;
import org.osgi.service.metatype.annotations.AttributeDefinition;
import org.osgi.service.metatype.annotations.Designate;
import org.osgi.service.metatype.annotations.ObjectClassDefinition;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.day.cq.wcm.api.Page;
import com.day.cq.wcm.api.PageManager;

import lombok.Getter;
import pl.sii.website.core.common.infrastructure.repo.RepositoryConnection;
import pl.sii.website.core.common.infrastructure.repo.RepositoryConnectionFactory;
import pl.sii.website.core.services.SiiComponentService;

/**
 * The Class SiiComponentServiceImpl.
 */
@Component(
		service = SiiComponentService.class,
		immediate = true)
@Designate(
		ocd = SiiComponentServiceImpl.SiiComponentServiceConfig.class)
public class SiiComponentServiceImpl implements SiiComponentService {

	private static final Logger LOG = LoggerFactory.getLogger(SiiComponentServiceImpl.class);

	/**
	 * The Interface SiiComponentServiceConfig.
	 */
	@ObjectClassDefinition(
			name = "Sii Component Configuration")
	public @interface SiiComponentServiceConfig {

		/**
		 * Config entry.
		 *
		 * @return the string
		 */
		@AttributeDefinition(
				name = "Content Entry",
				defaultValue = { "local" })
		String configEntry();

		/**
		 * Path.
		 *
		 * @return the string
		 */
		@AttributeDefinition(
				name = "Path",
				defaultValue = { "" })
		String path();

	}

	@Getter
	private String configEntry;

	@Getter
	private String path;

	@Reference
	private RepositoryConnectionFactory repositoryConnectionFactory;

	/**
	 * Activate.
	 *
	 * @param config
	 *            the config
	 */
	@Activate
	protected void activate(final SiiComponentServiceConfig config) {
		this.configEntry = config.configEntry();
		this.path = config.path();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute(final ResourceResolver resolver) {
		LOG.info("in execute() resource resolver as parameter");

		if (resolver != null) {
			final PageManager pageManager = resolver.adaptTo(PageManager.class);

			if (pageManager != null) {
				final Page page = pageManager.getPage(this.path);

				if (page != null) {
					return page.getTitle();

				} else {
					return null;
				}
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public String execute() {
		LOG.info("in execute() own resource resolver");

		try (RepositoryConnection repositoryConnection = this.repositoryConnectionFactory.getConnection()) {
			final Page page = repositoryConnection.getPageManager().getPage(this.path);

			if (page != null) {
				return page.getTitle();
			}
			return null;
		}
	}

}
