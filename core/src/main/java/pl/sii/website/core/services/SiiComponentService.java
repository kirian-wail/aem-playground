package pl.sii.website.core.services;

import org.apache.sling.api.resource.ResourceResolver;

/**
 * The Interface SiiComponentService.
 */
public interface SiiComponentService {

	/**
	 * Execute.
	 *
	 * @param resolver
	 *            the resolver
	 * @return the string
	 */
	String execute(ResourceResolver resolver);

	/**
	 * Execute.
	 *
	 * @return the string
	 */
	String execute();

}
