package boj_1003_피보나치함수;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int[] tc = new int[T];

		int maxTC = Integer.MIN_VALUE;

		for (int t = 0; t < T; t++) {
			tc[t] = sc.nextInt();
			maxTC = Math.max(maxTC, tc[t]);
		}

		int[][] dp = new int[2][maxTC + 1];

		if (maxTC > 1) {
			dp[0][0] = 1;
			dp[1][1] = 1;

			for (int i = 2; i <= maxTC; i++) {
				dp[0][i] = dp[0][i - 1] + dp[0][i - 2];
				dp[1][i] = dp[1][i - 1] + dp[1][i - 2];
			}

			for (int t = 0; t < T; t++) {
				System.out.println(dp[0][tc[t]] + " " + dp[1][tc[t]]);
			}
		} else {
			for (int t = 0; t < T; t++) {
				if (tc[t] == 0) {
					System.out.println(1 + " " + 0);
				} else {
					System.out.println(0 + " " + 1);
				}
			}
		}
		sc.close();
	}
}
