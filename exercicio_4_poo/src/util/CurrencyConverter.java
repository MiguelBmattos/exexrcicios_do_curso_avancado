package util;

public class CurrencyConverter {
	public static final double IOF = 0.06;

	public static double pay(double precoDolar, double dolarQnt) {
		double resultado = precoDolar * dolarQnt;
		return resultado + resultado * IOF;
	}
}
