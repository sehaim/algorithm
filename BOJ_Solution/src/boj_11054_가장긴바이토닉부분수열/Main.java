package boj_11054_가장긴바이토닉부분수열;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int[] A = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			A[i] = Integer.parseInt(st.nextToken());
		}
		
		int[][] dp = new int[2][N];

//		int[] dp = new int[N];
//		Arrays.fill(dp, 1);
//
//		int max = 1;
//
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < i; j++) {
//				if (A[i] > A[j] && dp[j] + 1 > dp[i]) {
//					dp[i] = dp[j] + 1;
//					max = Math.max(max, dp[i]);
////					System.out.println("nor");
////					for (int m = 0; m < N; m++) {
////						System.out.print(dp[m] + " ");
////					}
////					System.out.println();
//				} else if (A[i] < A[j]) {
//					int[] dp_de = new int[N];
//					Arrays.fill(dp_de, dp[j]);
//					for (int k = j; k < N; k++) {
//						for (int l = j; l < k; l++) {
//							if (A[k] < A[l] && dp_de[l] + 1 > dp_de[k]) {
//								dp_de[k] = dp_de[l] + 1;
//								max = Math.max(max, dp_de[k]);
////								System.out.println("de");
////								for (int m = 0; m < N; m++) {
////									System.out.print(dp_de[m] + " ");
////								}
////								System.out.println();
//							}
//						}
//					}
//				}
//			}
//		}

		System.out.println(max);
	}
}
