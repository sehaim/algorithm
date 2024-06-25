package boj_16928_뱀과사다리게임;

import java.util.*;

public class Main {
	// 현재 위치와 주사위 횟수 정보를 담을 Pair 객체 
	static class Pair {
		int curr;
		int roll;

		public Pair(int curr, int roll) {
			this.curr = curr;
			this.roll = roll;
		}
	}

	static int[] adj;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();

		adj = new int[101];
		visited = new boolean[101];
		
		// 뱀, 사다리 종류에 상관없이 A -> B 로 이동하므로 한번에 입력 받을 수 있음 
		for (int i = 0; i < N + M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A] = B;
		}
		
		BFS();

		sc.close();
	}

	public static void BFS() {
		Queue<Pair> queue = new LinkedList<Pair>();
		
		// 처음 시작 위치와 주사위 횟수 
		Pair pair = new Pair(1, 0);

		queue.add(pair);

		while (!queue.isEmpty()) {
			Pair thisPair = queue.poll();
			
			// 현재 위치가 100이면 주사위 횟수를 출력하고 종료 
			if (thisPair.curr == 100) {
				System.out.println(thisPair.roll);
				return;
			}
			
			// 현재 위치에서 뱀이나 사다리가 존재하면 해당 위치로 변경 
			if(adj[thisPair.curr] != 0) {
				thisPair.curr = adj[thisPair.curr];
				visited[thisPair.curr] = true;
			}

			// 현재 위치에서 주사위를 1부터 6까지 굴리며 Queue에 삽입 
			for (int i = 1; i < 7; i++) {
				if (thisPair.curr + i <= 100 && !visited[thisPair.curr+i]) {
					Pair newPair = new Pair(thisPair.curr + i, thisPair.roll + 1);
					queue.add(newPair);
					visited[newPair.curr] = true;
				}
			}
		}
	}
}
