package excepcion;

public class ErrorDeMatriz extends RuntimeException {

	/**
	 * Construye esta excepción con un mensaje.
	 * @param mensaje El mensaje.
	 */
	public ErrorDeMatriz(final String mensaje) {
		super(mensaje);
	}

	/**
	 * Construye esta excepción con otra excepción.
	 * @param t La otra excepción.
	 */
	public ErrorDeMatriz(final Throwable t) {
		super(t);
	}

}
