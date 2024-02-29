package SWEA_7465_창용마을무리의개수;

import java.util.Scanner;

public class Solution {
	static int[] arr;
	static int num;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;
		
		while (x <= T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			num = 0;
			arr = new int[N];

			for (int i = 0; i < M; i++) {
				bfs(sc.nextInt() - 1, sc.nextInt() - 1);
			}

			System.out.println("#" + x + " " + num);
			x++;
		}
		sc.close();
	}

	public static void bfs(int idx1, int idx2) {
		if (arr[idx1] == 0 && arr[idx2] == 0) {
			arr[idx1] = arr[idx2] = ++num;
		} else if (arr[idx1] == 0 && arr[idx2] != 0) {
			arr[idx1] = arr[idx2];
		} else if (arr[idx1] != 0 && arr[idx2] == 0) {
			arr[idx2] = arr[idx1];
		}
	}
}
