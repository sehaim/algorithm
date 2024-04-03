package SWEA_4014_활주로건설;

import java.util.Scanner;

public class Solution {

	static int[][] arr;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static boolean[][] visited;
	static int N, K, K_Num, length, max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int max = Integer.MIN_VALUE;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					max = Math.max(max, arr[r][c]);
				}
			}

			K_Num = 0;
			length = 0;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == max) {
						visited = new boolean[N][N];
						visited[r][c] = true;
						dfs(r, c, 0);
					}
				}
			}

			System.out.println("#" + t + " " + length);
			t++;
		}
		sc.close();
	}

	public static void dfs(int r_idx, int c_idx, int num) {
		if (K_Num > 1 || r_idx < 0 || r_idx >= N || c_idx < 0 || c_idx >= N) {
			length = Math.max(length, num);
			return;
		}

		for (int d = 0; d < 4; d++) {
			int nr = r_idx + dr[d];
			int nc = c_idx + dc[d];
			if (nr >= 0 && nr < N && nc >= 0 && nc < N && !visited[nr][nc]) {
				if (arr[r_idx][c_idx] > arr[nr][nc]) {
					visited[nr][nc] = true;
					dfs(nr, nc, num + 1);
					visited[nr][nc] = false;
				} else {
					if (arr[nr][nc] - arr[r_idx][c_idx] < K) {
						int tmp = arr[nr][nc];
						for (int i = arr[r_idx][c_idx] - 1; i >= arr[r_idx][c_idx] - K; i--) {
							arr[nr][nc] = i;
							visited[nr][nc] = true;
							K_Num++;
							dfs(nr, nc, num + 1);
							K_Num--;
							visited[nr][nc] = false;
						}
						arr[nr][nc] = tmp;
					} else {
						dfs(-1, -1, num + 1);
					}
				}
			} else {
				dfs(-1, -1, num + 1);
			}
		}
	}
}