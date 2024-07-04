package boj_1463_1로만들기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int[] dp = new int[N + 1];

		for (int i = 2; i < N + 1; i++) {
			// 일단 이전 숫자 결과에 1 더한 수로 저장 
			dp[i] = dp[i - 1] + 1;
			
			// 2의 배수일 경우 현재 결과와 (2로 나눈 수+1) 중 최소값 저장
			if (i % 2 == 0) {
				dp[i] = Math.min(dp[i / 2] + 1, dp[i]);
			}
			// 3의 배수일 경우 현재 결과와 (3로 나눈 수+1) 중 최소값 저장
			if (i % 3 == 0) {
				dp[i] = Math.min(dp[i / 3] + 1, dp[i]);
			}
		}

		System.out.println(dp[N]);

		sc.close();
	}
}