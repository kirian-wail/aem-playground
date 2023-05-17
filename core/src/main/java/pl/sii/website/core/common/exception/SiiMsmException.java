package pl.sii.website.core.common.exception;

/**
 * The Class SiiException.
 *
 * @author Jaroslav Rassadin
 */
public class SiiMsmException extends Exception {

	private static final long serialVersionUID = 2049474821314962192L;

	/**
	 * Instantiates a new Sii exception.
	 *
	 * @param message
	 *            the message
	 */
	public SiiMsmException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new Sii exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public SiiMsmException(final String message, final Throwable cause) {
		super(message, cause);
	}
}
