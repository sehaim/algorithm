package swea_7465_창용마을무리의개수;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;

		while (x <= T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[] arr = new int[N + 1];

			for (int i = 0; i < N + 1; i++) {
				arr[i] = i;
			}

			for (int i = 0; i < M; i++) {
				int idx1 = sc.nextInt();
				int idx2 = sc.nextInt();
				int min = Math.min(arr[idx1], arr[idx2]);
				int max = Math.max(arr[idx1], arr[idx2]);

				for (int j = 0; j < N + 1; j++) {
					if (arr[j] == max) {
						arr[j] = min;
					}
				}
			}

			int[] idxArr = new int[N + 1];
			int num = 0;

			for (int i = 1; i < N + 1; i++) {
				idxArr[arr[i]]++;
			}

			for (int i = 1; i < N + 1; i++) {
				if (idxArr[i] != 0) {
					num++;
				}
			}

			System.out.println("#" + x + " " + num);
			x++;
		}
		sc.close();
	}
}
