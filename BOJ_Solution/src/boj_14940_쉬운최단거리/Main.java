package boj_14940_쉬운최단거리;

import java.io.*;
import java.util.*;

public class Main {
	// 해당 인덱스의 정보를 담는 객체 선언 
	static class arrInfo {
		int r_idx;
		int c_idx;
		int dist;

		public arrInfo(int r_idx, int c_idx, int dist) {
			this.r_idx = r_idx;
			this.c_idx = c_idx;
			this.dist = dist;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		int[][] arr = new int[N][M];
		boolean[][] visited = new boolean[N][M];

		Queue<arrInfo> queue = new LinkedList<arrInfo>();

		for (int r = 0; r < N; r++) {
			str = br.readLine().split(" ");
			int idx = 0;
			for (int c = 0; c < M; c++) {
				arr[r][c] = Integer.parseInt(str[idx++]);
				// 목적지를 발견하면 queue에 삽입 후 방문 check, 거리는 0이므로 배열 값 변경 
				if (arr[r][c] == 2) {
					queue.add(new arrInfo(r, c, 0));
					visited[r][c] = true;
					arr[r][c] = 0;
				} else if (arr[r][c] == 0) { // 0인 경우는 갈 수 없으므로 visited를 true로 변경 
					visited[r][c] = true;
				}
			}
		}

		int[] dr = { -1, 1, 0, 0 };
		int[] dc = { 0, 0, -1, 1 };

		while (!queue.isEmpty()) {
			arrInfo curr = queue.poll();
			
			// 사방 탐색 
			for (int d = 0; d < 4; d++) {
				int nr = curr.r_idx + dr[d];
				int nc = curr.c_idx + dc[d];

				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc]) { // 0인 경우 visited를 true로 변경해놓았기 때문에 따로 조건 필요 없음 
					// 갈 수 있는 곳이면 현재 거리 + 1 로 배열 값 변경 후 queue에 삽입 
					arr[nr][nc] = curr.dist + 1;
					queue.add(new arrInfo(nr, nc, curr.dist + 1));
					// 방문 check 
					visited[nr][nc] = true;
				}
			}
		}
		
		// visited가 false인 곳은 땅이지만 도달할 수 없는 곳이므로 배열 값 -1로 변경 
		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				if (!visited[r][c]) {
					arr[r][c] = -1;
				}
			}
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < M; c++) {
				bw.write(arr[r][c] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}
}
