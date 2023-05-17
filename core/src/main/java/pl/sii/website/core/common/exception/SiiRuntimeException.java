package pl.sii.website.core.common.exception;

/**
 * The Class SiiRuntimeException.
 *
 * @author Jaroslav Rassadin
 */
public class SiiRuntimeException extends RuntimeException {

	private static final long serialVersionUID = 8852132786577390036L;

	/**
	 * Instantiates a new Sii runtime exception.
	 *
	 * @param message
	 *            the message
	 */
	public SiiRuntimeException(final String message) {
		super(message);
	}

	/**
	 * Instantiates a new Sii runtime exception.
	 *
	 * @param cause
	 *            the cause
	 */
	public SiiRuntimeException(final Throwable cause) {
		super(cause);
	}

	/**
	 * Instantiates a new Sii runtime exception.
	 *
	 * @param message
	 *            the message
	 * @param cause
	 *            the cause
	 */
	public SiiRuntimeException(final String message, final Throwable cause) {
		super(message, cause);
	}

}
