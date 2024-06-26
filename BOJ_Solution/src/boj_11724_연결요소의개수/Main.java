package boj_11724_연결요소의개수;

import java.util.*;

public class Main {
	static int N, M, cnt;
	static List<Integer>[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();
		M = sc.nextInt();

		adj = new ArrayList[N + 1];
		visited = new boolean[N + 1];

		// 그래프 순회하며 ArrayList로 초기화
		for (int i = 1; i < N + 1; i++) {
			adj[i] = new ArrayList<Integer>();
		}

		// 간선 입력
		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A].add(B);
			adj[B].add(A);
		}
		
		cnt = 0;
		
		// 모든 노드 방문 
		for (int i = 1; i < N + 1; i++) {
			// 방문 노드의 visited가 false 이면 그룹이 존재하는 것이므로 cnt 증가 
			if(!visited[i]) {
				DFS(i);		
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}

	public static void DFS(int V) {
		visited[V] = true;
		
		for (int i = 0; i < adj[V].size(); i++) {
			int v = adj[V].get(i);
			
			if(!visited[v]) {
				DFS(v);				
			}
		}
	}
}
