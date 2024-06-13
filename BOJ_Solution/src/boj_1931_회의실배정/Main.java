package boj_1931_회의실배정;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int N, max;
	static int[] start, end;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();

		start = new int[N];
		end = new int[N];
		visited = new boolean[N];

		for (int i = 0; i < N; i++) {
			start[i] = sc.nextInt();
			end[i] = sc.nextInt();
		}

		System.out.println();
		sc.close();
	}
}
