package boj_9095_123더하기;

import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int t = 0; t < T; t++) {
			int n = sc.nextInt();
			int ans = 0;

			if (n == 1) {
				ans = 1;
			} else if (n == 2) {
				ans = 2;
			} else if (n == 3) {
				ans = 4;
			} else {
				int[] dp = new int[n + 1];
				dp[1] = 1;
				dp[2] = 2;
				dp[3] = 4;

				for (int i = 4; i < n + 1; i++) {
					dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
				}

				ans = dp[n];
			}

			System.out.println(ans);
		}

		sc.close();
	}
}
