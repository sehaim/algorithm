package boj_1260_DFS와BFS;

import java.util.*;
import java.util.Scanner;

public class Main {
	static int N;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		int M = sc.nextInt();
		int V = sc.nextInt();

		adj = new ArrayList[N + 1];

		// adj를 ArrayList<Integer>[]형태로 초기화
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		// 그래프 입력
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A].add(B);
			adj[B].add(A);
		}

		// 방문할 수 있는 정점이 여러개일 때, 번호가 가장 작은 것 부터 방문하도록 오름차순으로 정렬
		for (int i = 1; i < N + 1; i++) {
			Collections.sort(adj[i]);
		}

		visited = new boolean[N + 1];
		DFS(V);

		System.out.println();

		// BFS를 위해 visited 다시 초기화
		visited = new boolean[N + 1];
		BFS(V);

		sc.close();
	}

	public static void DFS(int V) {
		visited[V] = true;

		System.out.print(V + " ");

		for (int i = 0; i < adj[V].size(); i++) {
			if (!visited[adj[V].get(i)]) {
				DFS(adj[V].get(i));
			}
		}
	}

	public static void BFS(int V) {
		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(V);
		visited[V] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			System.out.print(curr + " ");

			for (int i = 0; i < adj[curr].size(); i++) {
				if (!visited[adj[curr].get(i)]) {
					queue.add(adj[curr].get(i));
					visited[adj[curr].get(i)] = true;
				}
			}
		}
	}
}
