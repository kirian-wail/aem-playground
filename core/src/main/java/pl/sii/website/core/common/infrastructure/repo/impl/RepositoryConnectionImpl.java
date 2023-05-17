package pl.sii.website.core.common.infrastructure.repo.impl;

import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.PageManager;

import pl.sii.website.core.common.infrastructure.repo.RepositoryConnection;

/**
 * The Class RepositoryConnectionImpl.
 *
 * @author Jaroslav Rassadin
 */
public class RepositoryConnectionImpl implements RepositoryConnection {

	private final ResourceResolver resourceResolver;

	/**
	 * Instantiates a new repository connection impl.
	 *
	 * @param resourceResolver
	 *            the resource resolver
	 */
	public RepositoryConnectionImpl(final ResourceResolver resourceResolver) {
		this.resourceResolver = resourceResolver;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void close() {
		this.resourceResolver.close();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public PageManager getPageManager() {
		if (this.resourceResolver != null) {
			return this.resourceResolver.adaptTo(PageManager.class);
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public ResourceResolver getResourceResolver() {
		return this.resourceResolver;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Session getSession() {
		if (this.resourceResolver != null) {
			return this.resourceResolver.adaptTo(Session.class);
		}
		return null;
	}

}
