package boj_1389_케빈베이컨의6단계법칙;

import java.io.*;
import java.util.*;

public class Main {
	static int INF = 987654321;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		List<Integer>[] relation = new ArrayList[N + 1]; // 관계 그래프
		int[][] minArr = new int[N + 1][N + 1]; // i-j 가 이어지는 최소 단계를 저장하는 2차원 배열

		for (int r = 1; r <= N; r++) {
			Arrays.fill(minArr[r], INF); // 최댓값으로 초기화
		}
		
		// N번째 행은 중복으로 BFS를 시행할 필요가 없기 때문에 미리 minArr[N][N]은 0으로 초기화 
		minArr[N][N] = 0;

		// 관계 그래프 초기화
		for (int i = 1; i <= N; i++) {
			relation[i] = new ArrayList<Integer>();
		}

		// 관계 그래프 입력
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());

			relation[A].add(B);
			relation[B].add(A);
		}

		// 모든 사람에 대해 BFS로 케빈 베이컨 게임 시행
		for (int i = 1; i < N; i++) {
			boolean[] visited = new boolean[N + 1];

			Queue<int[]> queue = new ArrayDeque<>();

			queue.add(new int[] { i, 0 }); // queue에 입력되는 1차원 배열 : { 사람, 거쳐온 단계 }

			while (!queue.isEmpty()) {
				int[] curr = queue.poll();

				minArr[i][curr[0]] = Math.min(minArr[i][curr[0]], curr[1]); // minArr에 저장된 단계와 queue에서 꺼낸 현재 단계를 비교해서
																			// 최솟값 저장
				minArr[curr[0]][i] = minArr[i][curr[0]];

				// 현재 사람과 인접한 사람들 중 아직 방문하지 않은 사람만 방문 check 후, queue에 삽입
				for (Integer j : relation[curr[0]]) {
					if (!visited[j]) {
						visited[j] = true;
						queue.add(new int[] { j, curr[1] + 1 });
					}
				}
			}
		}

		int ans = -1;
		int min = INF;

		for (int r = 1; r <= N; r++) {
			int sum = 0;

			// 모든 유저의 케빈 베이컨 수를 구함
			for (int c = 1; c <= N; c++) {
				sum += minArr[r][c];
			}

			// 그 중 최솟값 저장
			if (min > sum) {
				min = sum;
				ans = r;
			}
		}

		System.out.println(ans);
	}
}
