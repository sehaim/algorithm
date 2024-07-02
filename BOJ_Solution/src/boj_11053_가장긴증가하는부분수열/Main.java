package boj_11053_가장긴증가하는부분수열;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}

		int[] dp = new int[N];
		// 수열 크기의 최대값 저장 변수 
		int max = 1;
		
		// A 배열 0~N까지 순회 
		for (int i = 0; i < N; i++) {
			// 일단 모든 수에 대해 수열 크기의 최소값은 1이므로 1 저장 
			dp[i] = 1;
			
			// 0부터 i-1번째에 대해 값이 A[i]보다 작으면 해당 인덱스의 dp + 1 과 dp[i] 비교 
			for (int j = 0; j < i; j++) {
				if (A[j] < A[i] && dp[j] + 1 > dp[i]) {
					// dp[i]가 더 작으면 갱신 
					dp[i] = dp[j] + 1;
					max = Math.max(max, dp[i]);
				}
			}
		}
		
		System.out.println(max);
	}
}
