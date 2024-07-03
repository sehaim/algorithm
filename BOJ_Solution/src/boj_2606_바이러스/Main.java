package boj_2606_바이러스;

import java.util.*;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] adj = new int[N + 1][N + 1];
		boolean[] visited = new boolean[N + 1];

		for (int i = 0; i < M; i++) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			adj[A][B] = adj[B][A] = 1;
		}

		int cnt = 0;

		Queue<Integer> queue = new LinkedList<Integer>();

		queue.add(1);
		visited[1] = true;

		while (!queue.isEmpty()) {
			int curr = queue.poll();

			for (int i = 1; i < N + 1; i++) {
				if (adj[curr][i] == 1 && !visited[i]) {
					queue.add(i);
					visited[i] = true;
				}
			}

			cnt++;
		}

		System.out.println(cnt - 1);

		sc.close();
	}
}
