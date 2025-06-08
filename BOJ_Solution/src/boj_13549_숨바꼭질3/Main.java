package boj_13549_숨바꼭질3;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int ans = 100001;

		if (N >= K) {
			ans = N - K; // N이 K보다 크거나 같은 경우는 뒤로 한칸씩 이동하는 것이 가장 빠르다.
		} else {
			Queue<int[]> queue = new ArrayDeque<>();
			int[] visited = new int[100001]; // 갈 수 있는 최대 위치만큼 visited 크기 선언

			queue.add(new int[] { N * 2, 0 });
			queue.add(new int[] { N + 1, 1 });
			queue.add(new int[] { N - 1, 1 });

			while (!queue.isEmpty()) {
				int[] curr = queue.poll();

				// 현재 위치가 K와 같으면 최솟값 비교
				if (curr[0] == K) {
					ans = Math.min(ans, curr[1]);
				}

				int[] next = { curr[0] * 2, curr[0] + 1, curr[0] - 1 };

				for (int i = 0; i < 3; i++) {
					int n = next[i];

					if (n >= 0 && n <= 100000 && visited[n] < 4) {
						int second = i == 0 ? 0 : 1; // 순간이동이면 0초, 아니면 1초
						queue.add(new int[] { n, curr[1] + second });
						visited[n]++; // 방문 체크
					}
				}
			}
		}

		System.out.println(ans);
	}
}