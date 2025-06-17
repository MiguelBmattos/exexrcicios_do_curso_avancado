import java.util.Scanner;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] matrix = new int[n][m];

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = sc.nextInt();
			}
		}

		Integer x = sc.nextInt();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (x == matrix[i][j]) {
					System.out.println("Position" + i + "," + j + ":");
					if (j>0) {
						System.out.println("Left: "+matrix[i][j-1]);
					}
					if(i>0) {
						System.out.println("Up: "+matrix[i-1][j]);
					}
					if(j<matrix[i].length-1) {
						System.out.println("Right: "+matrix[i][j+1]);
					}
					if(i<matrix.length-1) {
						System.out.println("Down: "+matrix[i+1][j]);
					}
				}
			}
		}

		sc.close();
	}

}
