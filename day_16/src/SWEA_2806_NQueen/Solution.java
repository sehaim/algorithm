package SWEA_2806_NQueen;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static int N, num, ans;
	static int[][] arr;
	static int[] dr = { -1, -1, -1 };
	static int[] dc = { -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;

		while (x <= T) {
			N = sc.nextInt();
			num = 0;
			ans = 0;
			arr = new int[N][N];

			bfs(0);

			System.out.println("#" + x + " " + ans);

			x++;
		}
		sc.close();
	}

	public static void bfs(int r_idx) {
		if (r_idx >= N) {
			num = 0;
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == 2) num++;
				}
			}
			if(num == N) ans++;
			return;
		}

		for (int c = 0; c < N; c++) {
			if (arr[r_idx][c] == 0) {
				arr[r_idx][c] = 2;
				for (int d = 0; d < 3; d++) {
					for (int j = 1; j < N; j++) {
						int nr = r_idx + dr[d] * j;
						int nc = c + dc[d] * j;
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							arr[nr][nc] = 1;
						}
					}
				}
				bfs(r_idx + 1);
				for (int d = 0; d < 3; d++) {
					for (int j = 0; j < N; j++) {
						int nr = r_idx + dr[d] * j;
						int nc = c + dc[d] * j;
						if (nr >= 0 && nr < N && nc >= 0 && nc < N) {
							arr[nr][nc] = 0;
						}
					}
				}
			}
		}
	}
}
