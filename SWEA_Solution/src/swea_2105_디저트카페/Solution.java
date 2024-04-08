package swea_2105_디저트카페;

import java.util.Scanner;

public class Solution {
	static int N, ans, rs, cs;
	static int[][] arr;
	static boolean[][] visited;
	static int[] dr = { 1, 1, -1, -1 };
	static int[] dc = { -1, 1, 1, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			N = sc.nextInt();
			arr = new int[N][N];
			visited = new boolean[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			ans = -1;

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					rs = r;
					cs = c;
					dfs(r, c, 0, 0);
				}
			}

			System.out.println("#" + t + " " + ans);
			t++;
		}
		sc.close();
	}

	public static void dfs(int r_idx, int c_idx, int d, int cnt) {
		if (r_idx == rs && c_idx == cs && cnt != 0) {
			ans = Math.max(ans, cnt);
			return;
		}
		if (d >= 4)
			return;

		if (visited[r_idx][c_idx]) {
			return;
		}

		visited[r_idx][c_idx] = true;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == arr[r_idx][c_idx]) {
					visited[r][c] = true;
				}
			}
		}
			int nr = r_idx + dr[d];
			int nc = c_idx + dc[d];

			if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
				dfs(nr, nc, d, cnt + 1);
				dfs(nr, nc, d + 1, cnt + 1);
			}

		visited[r_idx][c_idx] = false;

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (arr[r][c] == arr[r_idx][c_idx]) {
					visited[r][c] = false;
				}
			}
		}
	}
}
