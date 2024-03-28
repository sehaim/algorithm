package SWEA_1251_하나로;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int[][] arr;
	static boolean[] visited;
	static double[] distArr;
	static int N;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			N = sc.nextInt();
			arr = new int[2][N];

			for (int r = 0; r < 2; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			double E = sc.nextDouble();
			double min = Double.MAX_VALUE;

			for (int i = 0; i < N; i++) {
				visited = new boolean[N];
				distArr = new double[N];
				double ans = 0;
				prim(i);

				for (int j = 0; j < N; j++) {
					ans += distArr[j] * E;
				}

				min = Math.min(ans, min);
			}

			System.out.printf("#%d %.0f", t, min);
			System.out.println();
			t++;
		}

		sc.close();
	}

	public static void prim(int i) {
		visited[i] = true;

		long min = Long.MAX_VALUE;
		int idx = -1;

		for (int j = 0; j < N; j++) {
			if (!visited[j]) {
				long dist = (long) Math.pow((arr[0][i] - arr[0][j]), 2) + (long) Math.pow((arr[1][i] - arr[1][j]), 2);
				min = Math.min(min, dist);
				if (min == dist)
					idx = j;
			}
		}

		if (idx != -1) {
			distArr[i] = min;
			prim(idx);
		}
	}
}
