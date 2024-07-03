package boj_7576_토마토;

import java.io.*;
import java.util.*;

public class Main {
	static class Tomato {
		int r_idx;
		int c_idx;
		int days;

		public Tomato(int r_idx, int c_idx, int days) {
			this.r_idx = r_idx;
			this.c_idx = c_idx;
			this.days = days;
		}
	}

	static int N, M, ans;
	static int[][] box;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());

		box = new int[N][M];
		visited = new boolean[N][M];

		Queue<Tomato> queue = new LinkedList<Tomato>();

		for (int r = 0; r < N; r++) {
			st = new StringTokenizer(br.readLine());

			for (int c = 0; c < M; c++) {
				box[r][c] = Integer.parseInt(st.nextToken());
				if (box[r][c] == 1) {
					queue.add(new Tomato(r, c, 0));
					visited[r][c] = true;
				} else if (box[r][c] == -1) {
					visited[r][c] = true;
				}
			}
		}
		
		ans = 0;

		while (!queue.isEmpty()) {
			Tomato curr = queue.poll();
			
			ans = curr.days;

			for (int d = 0; d < 4; d++) {
				int nr = curr.r_idx + dr[d];
				int nc = curr.c_idx + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) {
					queue.add(new Tomato(nr, nc, curr.days+1));
					visited[nr][nc] = true;
				}
			}
		}
		
		for (int r=0; r<N; r++) {
			for (int c=0; c<M; c++) {
				if(!visited[r][c]) {
					ans = -1;
					break;
				}
			}
		}
		
		System.out.println(ans);

	}
}
