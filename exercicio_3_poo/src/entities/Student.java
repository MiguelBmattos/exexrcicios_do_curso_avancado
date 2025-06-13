package entities;

public class Student {
	public String name;
	public double nota1;
	public double nota2;
	public double nota3;
	public double soma;

	public double soma() {
		soma = nota1 + nota2 + nota3;
		return soma;
	}

	public String coondition() {
		String pass = "Pass";
		String failed = "Failed";
		if (soma >= 60.00) {
			return pass;
		} else {
			return failed;
		}
	}

	public double missing() {
		if (soma < 60.00) {
			return 60.00 - soma;
		} else {
			return 0.0;
		}

	}
}
