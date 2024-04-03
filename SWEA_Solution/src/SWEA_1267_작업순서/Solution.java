package SWEA_1267_작업순서;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		while (t <= 10) {
			int V = sc.nextInt();
			int E = sc.nextInt();

			int[][] adj = new int[V + 1][V + 1];
			int[] degree = new int[V + 1];

			for (int i = 0; i < E; i++) {
				int A = sc.nextInt();
				int B = sc.nextInt();

				adj[A][B] = 1;
				degree[B]++;
			}

			Queue<Integer> queue = new LinkedList<>();

			for (int i = 1; i < V + 1; i++) {
				if (degree[i] == 0) {
					queue.offer(i);
				}
			}

			System.out.print("#" + t + " ");

			while (!queue.isEmpty()) {
				int curr = queue.poll();
				System.out.print(curr + " ");
				for (int i = 1; i < V + 1; i++) {
					if (adj[curr][i] == 1) {
						degree[i]--;

						if (degree[i] == 0) {
							queue.offer(i);
						}
					}
				}
			}

			System.out.println();
			t++;
		}
		sc.close();
	}
}
