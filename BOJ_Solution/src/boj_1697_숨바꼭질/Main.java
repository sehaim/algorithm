package boj_1697_숨바꼭질;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int K = sc.nextInt();

		Queue<int[]> queue = new LinkedList<int[]>();

		int[] curr = new int[2];
		boolean[] visited = new boolean[100001];

		queue.add(new int[] { N, 0 });

		while (!queue.isEmpty()) {
			curr = queue.poll();

			if (curr[0] == K) {
				System.out.println(curr[1]);
				break;
			}

			int[] npArr = new int[] { curr[0] - 1, curr[0] + 1, curr[0] * 2 };
			
			for(int np : npArr) {
				if(np >= 0 && np <= 100000 && !visited[np]) {
					queue.add(new int[] {np, curr[1] + 1 });
					visited[np] = true;
				}
			}
		}
		sc.close();
	}
}
