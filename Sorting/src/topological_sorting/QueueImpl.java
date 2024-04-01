package topological_sorting;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueueImpl {
	public static String[] cook = { "", "재료구매", "양념장만들기", "고기재우기", "고기손질", "제육볶음만들기", "식사", "뒷정리", "채소손질", "밥하기" };

	public static String input = "9 9\r\n" + "1 4\r\n" + "1 8\r\n" + "2 3\r\n" + "4 3\r\n" + "8 5\r\n" + "3 5\r\n"
			+ "5 6\r\n" + "9 6\r\n" + "6 7\r\n" + "";

	public static void main(String[] args) {
		Scanner sc = new Scanner(input);

		int V = sc.nextInt(); // 정점의 수
		int E = sc.nextInt(); // 간선의 수 // 방향 있음

		int[][] adj = new int[V + 1][V + 1]; // 정점의 번호가 1번부터 시작이기 때문에 배열의 크기는 V+1
		int[] degree = new int[V + 1]; // 진입차수 저장

		for (int i = 0; i < E; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A][B] = 1; // 가중치가 따로 없기 때문에 1로 표기, 유향이기 때문에 반대는 처리하지 않는다.

			// 진입차수 증가
			degree[B]++;
		}

		Queue<Integer> queue = new LinkedList<>();

		// 1. 진입차수가 0인 정점들을 넣는다.
		for (int i = 1; i < V + 1; i++) {
			if (degree[i] == 0)
				queue.offer(i);
		}

		StringBuilder sb = new StringBuilder();

		// 2. Queu가 공백상태가 될 때까지 반복한다.
		while (!queue.isEmpty()) {
			// queue에서 정점을 한 개씩 꺼낸다.
			int curr = queue.poll();
			sb.append(cook[curr] + "\n");
			// 연결되어 있는 간선을 제거 (실제로 제거하는 것은 아님)
			for (int i = 0; i < V + 1; i++) {
				if (adj[curr][i] == 1) {
					degree[i]--; // 진입차수를 1씩 줄인다.
					adj[curr][i] = 0; // 간선 제거

					// 진입차수가 새롭게 0이 되었다면 queue에 넣는다.
					if (degree[i] == 0)
						queue.offer(i);
				}
			}
		}

		System.out.println(sb);

		sc.close();
	}
}
