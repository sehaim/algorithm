package boj_1916_최소비용구하기;

import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int v;
		int w;

		public Node(int v, int w) {
			this.v = v;
			this.w = w;
		}

		@Override
		public int compareTo(Node o) {
			return this.w - o.w;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		List<Node>[] adj = new ArrayList[N + 1];

		for (int i = 0; i <= N; i++) {
			adj[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());

			int s = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adj[s].add(new Node(v, w));
		}

		st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		int[] dist = new int[N + 1];
		boolean[] visited = new boolean[N + 1];

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[start] = 0;

		// Dijkstra
		PriorityQueue<Node> pq = new PriorityQueue<Node>();

		pq.add(new Node(start, dist[start]));

		while (!pq.isEmpty()) {
			Node curr = pq.poll();

			// 도착 지점에 도달하면 종료
			if (curr.v == end)
				break;

			if (visited[curr.v])
				continue;

			visited[curr.v] = true;

			for (Node node : adj[curr.v]) {
				if (!visited[node.v] && dist[node.v] > curr.w + node.w) {
					dist[node.v] = curr.w + node.w;
					pq.add(new Node(node.v, dist[node.v]));
				}
			}
		}

		System.out.println(dist[end]);
	}
}
