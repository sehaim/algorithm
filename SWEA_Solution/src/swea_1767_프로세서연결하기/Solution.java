package swea_1767_프로세서연결하기;

import java.util.Scanner;

public class Solution {
	static int N, cnt, min, max;
	static int[][] coreIdx;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			N = sc.nextInt();

			int[][] arr = new int[N][N];

			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			coreIdx = new int[2][12];
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			cnt = 0;

			int idx = 0;

			for (int r = 1; r < N - 1; r++) {
				for (int c = 1; c < N - 1; c++) {
					if (arr[r][c] == 1) {
						coreIdx[0][idx] = r;
						coreIdx[1][idx] = c;
						idx++;
						cnt++;
					}
				}
			}

			dfs(0, arr, 0);

			System.out.println("#" + t + " " + min);
			t++;
		}
		sc.close();
	}

	public static void dfs(int idx, int[][] arr, int connectCnt) {
		if (idx > cnt) {
			int len = 0;
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < N; c++) {
					if (arr[r][c] == 2) {
						len++;
					}
				}
			}

			if (connectCnt != max) {
				if (connectCnt > max) {
					max = Math.max(max, connectCnt);
					min = len;
				}
			} else {
				min = Math.min(min, len);
			}
			return;
		}

		label: for (int d = 0; d < 4; d++) {
			for (int i = 1; i < N - 1; i++) {
				int nr = coreIdx[0][idx] + i * dr[d];
				int nc = coreIdx[1][idx] + i * dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					if (arr[nr][nc] == 1 || arr[nr][nc] == 2)
						continue label;
				}
			}

			for (int i = 1; i < N - 1; i++) {
				int nr = coreIdx[0][idx] + i * dr[d];
				int nc = coreIdx[1][idx] + i * dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					arr[nr][nc] = 2;
				}
			}

			dfs(idx + 1, arr, connectCnt + 1);

			for (int i = 1; i < N - 1; i++) {
				int nr = coreIdx[0][idx] + i * dr[d];
				int nc = coreIdx[1][idx] + i * dc[d];
				if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
					arr[nr][nc] = 0;
				}
			}
		}
		dfs(idx + 1, arr, connectCnt);
	}
}
