package boj_2533_사회망서비스;

import java.util.*;

public class Main {
	static class Node {
		int v;
		boolean isEA;

		public Node(int v, boolean isEA) {
			this.v = v;
			this.isEA = isEA;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();

		List<Node>[] adj = new ArrayList[N + 1];

		for (int i = 0; i < N + 1; i++) {
			adj[i] = new ArrayList<Node>();
		}

		for (int i = 0; i < N; i++) {
			int u = sc.nextInt();
			int v = sc.nextInt();

			adj[u].add(new Node(v, false));
			adj[v].add(new Node(u, false));
		}
		
		
		

		sc.close();
	}
}
