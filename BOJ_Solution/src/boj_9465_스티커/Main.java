package boj_9465_스티커;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();

		int T = Integer.parseInt(br.readLine());

		for (int t = 0; t < T; t++) {
			int n = Integer.parseInt(br.readLine());

			int[][] arr = new int[2][n];
			int[][] dp = new int[2][n];

			for (int r = 0; r < 2; r++) {
				st = new StringTokenizer(br.readLine());

				for (int c = 0; c < n; c++) {
					arr[r][c] = Integer.parseInt(st.nextToken());
				}
			}

			int ans = 0;

			sb.append(ans + "\n");
		}
		
		System.out.print(sb);
	}
}
