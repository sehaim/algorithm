package boj_7569_토마토;

import java.io.*;
import java.util.*;

public class Main {
	static class Tomato {
		int h_idx, r_idx, c_idx, days;

		public Tomato(int h_idx, int r_idx, int c_idx, int days) {
			this.h_idx = h_idx;
			this.r_idx = r_idx;
			this.days = days;
			this.c_idx = c_idx;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());

		int[][][] tomato = new int[H][N][M];
		boolean[][][] visited = new boolean[H][N][M];

		Queue<Tomato> queue = new LinkedList<Tomato>();

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				st = new StringTokenizer(br.readLine());
				for (int c = 0; c < M; c++) {
					tomato[h][r][c] = Integer.parseInt(st.nextToken());
					if (tomato[h][r][c] == 1) {
						queue.add(new Tomato(h, r, c, 0));
						visited[h][r][c] = true;
					} else if (tomato[h][r][c] == -1) {
						visited[h][r][c] = true;
					}
				}
			}
		}

		int[] dh = { -1, 1, 0, 0, 0, 0 };
		int[] dr = { 0, 0, -1, 1, 0, 0 };
		int[] dc = { 0, 0, 0, 0, -1, 1 };

		int ans = 0;

		while (!queue.isEmpty()) {
			Tomato curr = queue.poll();

			ans = curr.days;

			for (int d = 0; d < 6; d++) {
				int nh = curr.h_idx + dh[d];
				int nr = curr.r_idx + dr[d];
				int nc = curr.c_idx + dc[d];

				if (nh >= 0 && nh < H && nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nh][nr][nc]) {
					queue.add(new Tomato(nh, nr, nc, ans + 1));
					visited[nh][nr][nc] = true;
				}
			}
		}

		for (int h = 0; h < H; h++) {
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (!visited[h][r][c]) {
						ans = -1;
					}
				}
			}
		}

		System.out.println(ans);

	}
}
