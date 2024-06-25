package boj_1012_유기농배추;

import java.util.*;
import java.util.Scanner;

public class Main {
	static int M, N, K, cnt;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int[][] arr;
	static boolean[][] visited;
	
	// 배추의 인덱스 값을 저장할 객체 선언 
	static class Idx {
		int r_idx;
		int c_idx;

		public Idx(int r_idx, int c_idx) {
			this.r_idx = r_idx;
			this.c_idx = c_idx;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int t = 0;

		while (t < T) {
			M = sc.nextInt();
			N = sc.nextInt();
			K = sc.nextInt();

			arr = new int[N][M];
			visited = new boolean[N][M];

			for (int i = 0; i < K; i++) {
				int c = sc.nextInt();
				int r = sc.nextInt();

				arr[r][c] = 1;
			}
			
			// 테스트 케이스마다 cnt 초기화 
			cnt = 0;
			
			// 배열을 순회하며 배추가 심어져 있고, 방문하지 않았으면 BFS 실행 
			for (int r = 0; r < N; r++) {
				for (int c = 0; c < M; c++) {
					if (arr[r][c] == 1 && !visited[r][c]) {
						BFS(r, c);
					}
				}
			}

			System.out.println(cnt);

			t++;
		}

		sc.close();
	}

	public static void BFS(int r_idx, int c_idx) {
		Queue<Idx> queue = new LinkedList<Idx>();

		queue.add(new Idx(r_idx, c_idx));
		visited[r_idx][c_idx] = true;

		while (!queue.isEmpty()) {
			Idx idx = queue.poll();
			
			// 인접한 경우이므로 사방탐색 
			for (int d = 0; d < 4; d++) {
				int nr = idx.r_idx + dr[d];
				int nc = idx.c_idx + dc[d];
				
				// 인접한 배추가 존재하고, 방문하지 않았으면 Queue에 삽입 
				if (nr >= 0 && nr < N && nc >= 0 && nc < M && !visited[nr][nc] && arr[nr][nc] == 1) {
					queue.add(new Idx(nr, nc));
					visited[nr][nc] = true;
				}
			}
		}
		
		// BFS를 한 번 실행할 때 마다 cnt 증가 
		cnt++;
	}
}
