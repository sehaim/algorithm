package boj_1922_네트워크연결;

import java.io.*;
import java.util.*;

public class Main {
	static class Edge implements Comparable<Edge> {
		int A, B, W;

		public Edge(int A, int B, int W) {
			this.A = A;
			this.B = B;
			this.W = W;
		}

		// 가중치에 대해 오름차순으로 정렬
		@Override
		public int compareTo(Edge o) {
			return this.W - o.W;
		}
	}

	static int[] p;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		p = new int[N + 1];
		Edge[] edges = new Edge[M];

		StringTokenizer st;

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			edges[i] = new Edge(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()),
					Integer.parseInt(st.nextToken()));
		}

		Arrays.sort(edges);

		// Make-Set
		for (int i = 1; i < N + 1; i++) {
			p[i] = i;
		}

		int ans = 0;
		int peek = 0;

		for (int i = 0; i < M; i++) {
			// i번째 간선의 대표를 찾아서 저장
			int pA = findset(edges[i].A);
			int pB = findset(edges[i].B);

			// 대표가 같으면 사이클이 존재하므로 continue
			if (pA == pB)
				continue;

			// 대표가 다르면 간선 선택 후 Union
			union(pA, pB);

			// 가중치 정답에 더하기
			ans += edges[i].W;
			// 뽑은 개수 더하기
			peek++;

			// N-1개 뽑았으면 다 뽑은 것임
			if (peek >= N - 1)
				break;

		}

		System.out.println(ans);

	}

	// Find-Set
	public static int findset(int x) {
		if (p[x] != x)
			return p[x] = findset(p[x]);
		return x;
	}

	// union
	public static void union(int x, int y) {
		p[x] = y;
	}
}
