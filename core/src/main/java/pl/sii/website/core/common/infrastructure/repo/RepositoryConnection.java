package pl.sii.website.core.common.infrastructure.repo;

import javax.jcr.Session;

import org.apache.sling.api.resource.ResourceResolver;

import com.day.cq.wcm.api.PageManager;

/**
 * The Interface RepositoryConnection.
 *
 * @author Jaroslav Rassadin
 */
public interface RepositoryConnection extends AutoCloseable {

	/**
	 * Redeclare without throwing exception.
	 */
	@Override
	void close();

	/**
	 * Gets the page manager.
	 *
	 * @return the page manager
	 */
	PageManager getPageManager();

	/**
	 * Gets the resource resolver.
	 *
	 * @return the resource resolver
	 */
	ResourceResolver getResourceResolver();

	/**
	 * Gets the session.
	 *
	 * @return the session
	 */
	Session getSession();
}
