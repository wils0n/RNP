package matriz;


import java.io.Serializable;

import excepcion.ErrorDeMatriz;

public class Matriz implements Cloneable, Serializable {

	public static Matriz crearMatrizColumna(final double entrada[]) {
		final double d[][] = new double[entrada.length][1];
		for (int fila = 0; fila < d.length; fila++) {
			d[fila][0] = entrada[fila];
		}
		return new Matriz(d);
	}

	public static Matriz crearMatrizFila(final double entrada[]) {
		final double d[][] = new double[1][entrada.length];
		System.arraycopy(entrada, 0, d[0], 0, entrada.length);
		return new Matriz(d);
	}

	double matriz[][];

	public Matriz(final boolean matrizOrigen[][]) {
		this.matriz = new double[matrizOrigen.length][matrizOrigen[0].length];
		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				if (matrizOrigen[r][c]) {
					this.set(r, c, 1);
				} else {
					this.set(r, c, -1);
				}
			}
		}
	}

	public Matriz(final double matrizOrigen[][]) {
		this.matriz = new double[matrizOrigen.length][matrizOrigen[0].length];
		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				this.set(r, c, matrizOrigen[r][c]);
			}
		}
	}

	public Matriz(final int rows, final int cols) {
		this.matriz = new double[rows][cols];
	}

	public void sumar(final int fila, final int columna, final double valor) {
		validar(fila, columna);
		final double nuevoValor = get(fila, columna) + valor;
		set(fila, columna, nuevoValor);
	}

	public void limpiar() {
		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				set(r, c, 0);
			}
		}
	}

	@Override
	public Matriz clone() {
		return new Matriz(this.matriz);
	}

	public boolean equals(final Matriz matriz) {
		return equals(matriz, 10);
	}

	public boolean equals(final Matriz matriz, int precision) {

		if (precision < 0) {
			throw new ErrorDeMatriz("Precisión no puede ser negativo.");
		}

		final double prueba = Math.pow(10.0, precision);
		if (Double.isInfinite(prueba) || (prueba > Long.MAX_VALUE)) {
			throw new ErrorDeMatriz("Precisión de " + precision
					+ " lugares decimales no es soportado.");
		}

		precision = (int) Math.pow(10, precision);

		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				if ((long) (get(r, c) * precision) != (long) (matriz.get(r, c) * precision)) {
					return false;
				}
			}
		}

		return true;
	}

	public int deArregloPlano(final Double[] arreglo, int indice) {

		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				this.matriz[r][c] = arreglo[indice++];
			}
		}

		return indice;
	}

	public double get(final int fila, final int columna) {
		validar(fila, columna);
		return this.matriz[fila][columna];
	}

	public Matriz getColumna(final int columna) {
		if (columna > getColumnas()) {
			throw new ErrorDeMatriz("No puede obtener columna #" + columna
					+ " ya que esta no existe.");
		}

		final double nuevaMatriz[][] = new double[getFilas()][1];

		for (int fila = 0; fila < getFilas(); fila++) {
			nuevaMatriz[fila][0] = this.matriz[fila][columna];
		}

		return new Matriz(nuevaMatriz);
	}

	public int getColumnas() {
		return this.matriz[0].length;
	}

	public Matriz getFila(final int fila) {
		if (fila > getFilas()) {
			throw new ErrorDeMatriz("No puede obtener fila #" + fila
					+ " ya que no existe.");
		}

		final double nuevaMatriz[][] = new double[1][getColumnas()];

		for (int columna = 0; columna < getColumnas(); columna++) {
			nuevaMatriz[0][columna] = this.matriz[fila][columna];
		}

		return new Matriz(nuevaMatriz);
	}

	public int getFilas() {
		return this.matriz.length;
	}

	public boolean esVector() {
		if (getFilas() == 1) {
			return true;
		} else {
			return getColumnas() == 1;
		}
	}

	public boolean esCero() {
		for (int fila = 0; fila < getFilas(); fila++) {
			for (int columna = 0; columna < getColumnas(); columna++) {
				if (this.matriz[fila][columna] != 0) {
					return false;
				}
			}
		}
		return true;
	}

	public void aleatorizar(final double min, final double max) {
		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				this.matriz[r][c] = (Math.random() * (max - min)) + min;
			}
		}
	}

	public void set(final int fila, final int columna, final double valor) {
		validar(fila, columna);
		if (Double.isInfinite(valor) || Double.isNaN(valor)) {
			throw new ErrorDeMatriz("Tratando de Asignar numero invalido a matriz: "
					+ valor);
		}
		this.matriz[fila][columna] = valor;
	}

	public int tamanno() {
		return this.matriz[0].length * this.matriz.length;
	}

	public double suma() {
		double resultado = 0;
		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				resultado += this.matriz[r][c];
			}
		}
		return resultado;
	}

	public Double[] aArregloPlano() {
		final Double resultado[] = new Double[getFilas() * getColumnas()];

		int indice = 0;
		for (int r = 0; r < getFilas(); r++) {
			for (int c = 0; c < getColumnas(); c++) {
				resultado[indice++] = this.matriz[r][c];
			}
		}

		return resultado;
	}

	private void validar(final int fila, final int columna) {
		if ((fila >= getFilas()) || (fila < 0)) {
			throw new ErrorDeMatriz("La fila:" + fila + " está fuera de rango:"
					+ getFilas());
		}

		if ((columna >= getColumnas()) || (columna < 0)) {
			throw new ErrorDeMatriz("La columna:" + columna + " está fuera de rango:"
					+ getColumnas());
		}
	}

}
