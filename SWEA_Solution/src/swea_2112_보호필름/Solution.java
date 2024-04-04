package swea_2112_보호필름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int D, W, K, min;
	static int[][] arr;
	static int[][] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int t = 1;

		String[] str;

		while (t <= T) {
			str = br.readLine().split(" ");
			D = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);

			arr = new int[D][W];

			for (int r = 0; r < D; r++) {
				str = br.readLine().split(" ");
				for (int c = 0; c < W; c++)
					arr[r][c] = Integer.parseInt(str[c]);
			}

			if (judgeK(arr)) {
				System.out.println("#" + t + " " + 0);
				t++;
				continue;
			}

			min = K;
			for (int k = 1; k < K; k++) {
				sel = new int[2][k];
				combination(0, 0, k);
			}

			System.out.println("#" + t + " " + min);
			t++;
		}

	}

	public static void dfs(int k) {
		int[][] newArr = new int[D][W];

		for (int r = 0; r < D; r++) {
			for (int c = 0; c < W; c++) {
				newArr[r][c] = arr[r][c];
			}
		}

		for (int i = 0; i < k; i++) {
			for (int c = 0; c < W; c++) {
				newArr[sel[0][i]][c] = sel[1][i];
			}
		}

		if (judgeK(newArr)) {
			min = k;
			return;
		}

	}

	public static void powerset(int idx, int k) {
		if (min < K)
			return;

		if (idx >= k) {
			dfs(k);
			return;
		}

		sel[1][idx] = 1;
		powerset(idx + 1, k);

		sel[1][idx] = 0;
		powerset(idx + 1, k);

	}

	public static void combination(int idx, int s_idx, int k) {
		if (min < K)
			return;

		if (s_idx >= k) {
			powerset(0, k);
			return;
		}

		for (int i = idx; i <= D - k + s_idx; i++) {
			sel[0][s_idx] = i;
			combination(i + 1, s_idx + 1, k);
		}
	}

	public static boolean judgeK(int[][] newArr) {
		boolean[] isOK = new boolean[W];

		for (int c = 0; c < W; c++) {
			int cnt = 1;

			for (int r = 0; r < D - 1; r++) {
				if (newArr[r][c] == newArr[r + 1][c])
					cnt++;
				else
					cnt = 1;
				if (cnt >= K) {
					isOK[c] = true;
					break;
				}
			}
			if (!isOK[c])
				break;
		}

		for (int i = 0; i < W; i++) {
			if (!isOK[i])
				return false;
		}

		return true;
	}
}
