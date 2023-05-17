package pl.sii.website.core.common.infrastructure.repo;

/**
 * A factory for creating RepositoryConnection objects.
 *
 * @author Jaroslav Rassadin
 */
public interface RepositoryConnectionFactory {

	/**
	 * Gets the connection.
	 *
	 * @return the connection
	 */
	RepositoryConnection getConnection();
}
