package excepcion;

public class ErrorRedNeuronal extends RuntimeException {

	/**
	 * Construye un mensaje de excepcion.
	 * 
	 * @param msg
	 *            Mensaje de excepción.
	 */
	public ErrorRedNeuronal(final String msg) {
		super(msg);
	}

	/**
	 * Construye una excepción que maneja otra excepción.
	 * 
	 * @param t
	 *            La otra excepción.
	 */
	public ErrorRedNeuronal(final Throwable t) {
		super(t);
	}
}
