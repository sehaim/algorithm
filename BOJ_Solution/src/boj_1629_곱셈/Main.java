package boj_1629_곱셈;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int A = sc.nextInt();
		int B = sc.nextInt();
		int C = sc.nextInt();

	}

	public static int op(int A, int B, int C) {
		int result = op(A, B / 2, C);
		if (B % 2 == 0) {
			return result * result % C;
		} else {
			return result * result;
		}
	}
}
