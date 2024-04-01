package topological_sorting;

import java.util.Scanner;
import java.util.Stack;

public class StackImpl {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static int V, E;
	public static int[][] adj;
	public static int[] degree;
	public static boolean[] visited; // 방문 체크
	public static Stack<Integer> stack;

	public static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
			+ "5 6\r\n" + "9 6\r\n" + "6 7\r\n" + "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		V = sc.nextInt(); // 정점의 수
		E = sc.nextInt(); // 간선의 수 // 방향 있음

		adj = new int[V + 1][V + 1]; // 정점의 번호가 1번부터 시작이기 때문에 배열의 크기는 V+1
		degree = new int[V + 1]; // 진입차수 저장
		visited = new boolean[V + 1];
		stack = new Stack<>();

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A][B] = 1; // 가중치가 따로 없기 때문에 1로 표기, 유향이기 때문에 반대는 처리하지 않는다.

			// 진입차수 증가
			degree[B]++;
		}

		for (int i = 1; i < V + 1; i++) {
			// 진입차수가 0인 정점들을 모두 DFS 탐색
			if (degree[i] == 0)
				DFS(i);
		}
		while (!stack.isEmpty()) {
			System.out.println(cook[stack.pop()]);
		}
		sc.close();
	}

	public static void DFS(int v) {
		visited[v] = true;

		for (int i = 1; i < V + 1; i++) {
			// 인접하고, 방문하지 않은 노드가 있다면 방문
			if (adj[v][i] == 1 && !visited[i]) {
				DFS(i);
			}
		}

		// 갈 수 있는 노드를 전부 탐색했으면 실행
		stack.add(v);
	}
}
