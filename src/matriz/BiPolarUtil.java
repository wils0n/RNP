package matriz;

/**
 * BiPolarUtil: Esta clase contiene un número de métodos utilitarios
 * usados para trabajar con números bipolares. Un número bipolar es otra
 * forma de representar números binarios. El valor de true se define
 * como uno, donde false se define como uno negativo.
 * 
 */
public class BiPolarUtil {

	public static double bipolarAdouble(final boolean b) {
		if (b) {
			return 1;
		} else {
			return -1;
		}
	}

	public static double[] bipolarAdouble(final boolean b[]) {
		final double[] resultado = new double[b.length];

		for (int i = 0; i < b.length; i++) {
			resultado[i] = bipolarAdouble(b[i]);
		}

		return resultado;
	}

	public static double[][] bipolarAdouble(final boolean b[][]) {
		final double[][] resultado = new double[b.length][b[0].length];

		for (int fila = 0; fila < b.length; fila++) {
			for (int columna = 0; columna < b[0].length; columna++) {
				resultado[fila][columna] = bipolarAdouble(b[fila][columna]);
			}
		}

		return resultado;
	}

	public static boolean doubleAbipolar(final double d) {
		if (d > 0) {
			return true;
		} else {
			return false;
		}
	}

	public static boolean[] doubleAbipolar(final double d[]) {
		final boolean[] resultado = new boolean[d.length];

		for (int i = 0; i < d.length; i++) {
			resultado[i] = doubleAbipolar(d[i]);
		}

		return resultado;
	}

	public static boolean[][] doubleAbipolar(final double d[][]) {
		final boolean[][] resultado = new boolean[d.length][d[0].length];

		for (int fila = 0; fila < d.length; fila++) {
			for (int columna = 0; columna < d[0].length; columna++) {
				resultado[fila][columna] = doubleAbipolar(d[fila][columna]);
			}
		}

		return resultado;
	}

	public static double normalizarBinario(final double d) {
		if (d > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	public static double aBinario(final double d) {
		return (d + 1) / 2.0;
	}

	public static double aBiPolar(final double d) {
		return (2 * normalizarBinario(d)) - 1;
	}

	public static double aBinarioNormalizado(final double d) {
		return normalizarBinario(aBinario(d));
	}

}
