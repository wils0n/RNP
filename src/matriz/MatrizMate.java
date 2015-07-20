package matriz;


import excepcion.ErrorDeMatriz;

/**
 * MatrizMate: Esta clase puede desarrollar varias operaciones
 * matemáticas diferentes en las matrices.
 * 
 */
public class MatrizMate {

	public static Matriz sumar(final Matriz a, final Matriz b) {
		if (a.getFilas() != b.getFilas()) {
			throw new ErrorDeMatriz(
					"Para sumar las matrices deben tener el mismo numero de filas y columnas.  Matriz a tiene "
							+ a.getFilas()
							+ " filas y la matriz b tiene "
							+ b.getFilas() + " filas.");
		}

		if (a.getColumnas() != b.getColumnas()) {
			throw new ErrorDeMatriz(
					"Para sumar las matrices deben tener el mismo numero de filas y columnas.  Matriz a tiene "
							+ a.getColumnas()
							+ " columnas y matriz b tiene "
							+ b.getColumnas() + " columnas.");
		}

		final double resultado[][] = new double[a.getFilas()][a.getColumnas()];

		for (int filaResultado = 0; filaResultado < a.getFilas(); filaResultado++) {
			for (int columnaResultado = 0; columnaResultado < a.getColumnas(); columnaResultado++) {
				resultado[filaResultado][columnaResultado] = a.get(filaResultado, columnaResultado)
						+ b.get(filaResultado, columnaResultado);
			}
		}

		return new Matriz(resultado);
	}

	public static void copiar(final Matriz origen, final Matriz destino) {
		for (int fila = 0; fila < origen.getFilas(); fila++) {
			for (int columna = 0; columna < origen.getColumnas(); columna++) {
				destino.set(fila, columna, origen.get(fila, columna));
			}
		}

	}


	public static Matriz borrarColumna(final Matriz matriz, final int aBorrar) {
		if (aBorrar >= matriz.getColumnas()) {
			throw new ErrorDeMatriz("No puede borrear columna " + aBorrar
					+ " desde matriz, esta tiene " + matriz.getColumnas()
					+ " columnas.");
		}
		final double nuevaMatriz[][] = new double[matriz.getFilas()][matriz
				.getColumnas() - 1];

		for (int fila = 0; fila < matriz.getFilas(); fila++) {
			int columnaDestino = 0;

			for (int columna = 0; columna < matriz.getColumnas(); columna++) {
				if (columna != aBorrar) {
					nuevaMatriz[fila][columnaDestino] = matriz.get(fila, columna);
					columnaDestino++;
				}

			}

		}
		return new Matriz(nuevaMatriz);
	}

	public static Matriz borrarFila(final Matriz matriz, final int aBorrar) {
		if (aBorrar >= matriz.getFilas()) {
			throw new ErrorDeMatriz("No puede borrar fila " + aBorrar
					+ " de matriz, esta tiene " + matriz.getFilas()
					+ " filas.");
		}
		final double nuevaMatriz[][] = new double[matriz.getFilas() - 1][matriz
				.getColumnas()];
		int filaDestino = 0;
		for (int fila = 0; fila < matriz.getFilas(); fila++) {
			if (fila != aBorrar) {
				for (int columna = 0; columna < matriz.getColumnas(); columna++) {
					nuevaMatriz[filaDestino][columna] = matriz.get(fila, columna);
				}
				filaDestino++;
			}
		}
		return new Matriz(nuevaMatriz);
	}

	public static Matriz dividir(final Matriz a, final double b) {
		final double resultado[][] = new double[a.getFilas()][a.getColumnas()];
		for (int fila = 0; fila < a.getFilas(); fila++) {
			for (int columna = 0; columna < a.getColumnas(); columna++) {
				resultado[fila][columna] = a.get(fila, columna) / b;
			}
		}
		return new Matriz(resultado);
	}

	public static double productoPunto(final Matriz a, final Matriz b) {
		if (!a.esVector() || !b.esVector()) {
			throw new ErrorDeMatriz(
					"Para efectuar producto punto, ambas matrices deben ser vectores.");
		}

		final Double aArray[] = a.aArregloPlano();
		final Double bArray[] = b.aArregloPlano();

		if (aArray.length != bArray.length) {
			throw new ErrorDeMatriz(
					"Para efectuar producto punto,"
                                + " ambas matrices deben tener la misma longitud.");
		}

		double resultado = 0;
		final int length = aArray.length;

		for (int i = 0; i < length; i++) {
			resultado += aArray[i] * bArray[i];
		}

		return resultado;
	}

	public static Matriz identidad(final int tamanno) {
		if (tamanno < 1) {
			throw new ErrorDeMatriz("Matriz identidad es de tamaño 1.");
		}

		final Matriz resultado = new Matriz(tamanno, tamanno);

		for (int i = 0; i < tamanno; i++) {
			resultado.set(i, i, 1);
		}

		return resultado;
	}

	public static Matriz multiplicar(final Matriz a, final double b) {
		final double resultado[][] = new double[a.getFilas()][a.getColumnas()];
		for (int fila = 0; fila < a.getFilas(); fila++) {
			for (int columna = 0; columna < a.getColumnas(); columna++) {
				resultado[fila][columna] = a.get(fila, columna) * b;
			}
		}
		return new Matriz(resultado);
	}

	public static Matriz multiplicar(final Matriz a, final Matriz b) {
		if (a.getColumnas() != b.getFilas()) {
			throw new ErrorDeMatriz(
					"Para la multiplicacion de matrices"
                                + " ordinarias, el número de columnas de la"
                                + " primera matriz debe ser igual al número de"
                                + " filas de la segunda.");
		}

		final double resultado[][] = new double[a.getFilas()][b.getColumnas()];

		for (int filaResultado = 0; filaResultado < a.getFilas(); filaResultado++) {
			for (int columnaResultado = 0; columnaResultado < b.getColumnas(); columnaResultado++) {
				double valor = 0;

				for (int i = 0; i < a.getColumnas(); i++) {

					valor += a.get(filaResultado, i) * b.get(i, columnaResultado);
				}
				resultado[filaResultado][columnaResultado] = valor;
			}
		}

		return new Matriz(resultado);
	}

	public static Matriz restar(final Matriz a, final Matriz b) {
		if (a.getFilas() != b.getFilas()) {
			throw new ErrorDeMatriz(
					"Para restar las matrices estas deben "
                                + " tener el mismo número de filas y columnas."
                                + " La matriz a tiene "
							+ a.getFilas()
							+ " filas y matriz b tiene "
							+ b.getFilas() + " filas.");
		}

		if (a.getColumnas() != b.getColumnas()) {
			throw new ErrorDeMatriz(
                                        "Para restar las matrices estas deben "
                                + " tener el mismo número de filas y columnas."
                                + " La matriz a tiene "
							+ a.getColumnas()
							+ " columnas y la matriz b tiene "
							+ b.getColumnas() + " columnas.");
		}

		final double resultado[][] = new double[a.getFilas()][a.getColumnas()];

		for (int filaResultado = 0; filaResultado < a.getFilas(); filaResultado++) {
			for (int columnaResultado = 0; columnaResultado < a.getColumnas(); columnaResultado++) {
				resultado[filaResultado][columnaResultado] = a.get(filaResultado, columnaResultado)
						- b.get(filaResultado, columnaResultado);
			}
		}

		return new Matriz(resultado);
	}

	public static Matriz transpuesta(final Matriz entrada) {
		final double matrizInversa[][] = new double[entrada.getColumnas()][entrada
				.getFilas()];

		for (int r = 0; r < entrada.getFilas(); r++) {
			for (int c = 0; c < entrada.getColumnas(); c++) {
				matrizInversa[c][r] = entrada.get(r, c);
			}
		}

		return new Matriz(matrizInversa);
	}

	/**
	 * Calcula la longitud del vector.
	 * 
	 * @param v
	 *            vector
	 * @return longitud del Vector.
	 */
	public static double longitudDeVector(final Matriz entrada) {
		if (!entrada.esVector()) {
			throw new ErrorDeMatriz(
					"Puede solo tomar la longitud de un vector");
		}
		final Double v[] = entrada.aArregloPlano();
		double rtn = 0.0;
		for (int i = 0; i < v.length; i++) {
			rtn += Math.pow(v[i], 2);
		}
		return Math.sqrt(rtn);
	}

	private MatrizMate() {
	}

}
