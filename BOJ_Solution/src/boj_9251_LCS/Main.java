package boj_9251_LCS;

import java.io.*;

public class Main {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	static int[] dp;
	static int max, tmp_max;
	static String str1, str2;

	public static void main(String[] args) throws IOException {
		str1 = br.readLine();
		str2 = br.readLine();

		dp = new int[str2.length() + 1];
		max = 0; // 전체 최댓값

		// str1 순회하며 dp 실행
		for (int i = 0; i < str1.length(); i++) {
			dp(str1.charAt(i));
		}

		System.out.print(max); // 최댓값 출력
	}

	public static void dp(char character) {
		tmp_max = 0; // dp 실행시 이전 index까지의 최댓값

		for (int i = 0; i < str2.length(); i++) {
			int tmp = dp[i]; // i번째에 저장되어 있는 dp값 임시 저장

			if (str2.charAt(i) == character) { // 같은 문자 발견하면
				tmp = Math.max(dp[i], tmp_max + 1); // 현재 dp 값과 (이전 index까지의 최댓값 + 1) 비교 후, 더 큰 값 tmp에 입력
			}

			tmp_max = Math.max(tmp_max, dp[i]); // 이전 index까지의 최댓값 갱신 (즉, i + 1 번째 실행 전에 i까지의 최댓값 저장)
			dp[i] = tmp; // i까지의 최댓값 저장 후 dp[i]에 tmp값 입력
			max = Math.max(max, dp[i]); // 전체 최댓값 갱신

		}
	}
}
