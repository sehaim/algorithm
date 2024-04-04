package swea_1486_장훈이의높은선반;

import java.util.Scanner;

public class Solution {
	static int N, B, min;
	static int[] arr, sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			N = sc.nextInt();
			B = sc.nextInt();

			arr = new int[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			min = Integer.MAX_VALUE;

			for (int i = 1; i <= N; i++) {
				sel = new int[i];
				combination(0, 0, i);
			}

			System.out.println("#" + t + " " + min);
			t++;
		}

		sc.close();
	}

	public static void combination(int idx, int s_idx, int n) {
		if (s_idx >= n) {
			int sum = 0;
			for (int i = 0; i < n; i++) {
				sum += arr[sel[i]];
			}

			if (sum < B)
				return;
			else {
				int diff = sum - B;
				min = Math.min(min, diff);
				return;
			}
		}

		for (int i = idx; i <= N - n + s_idx; i++) {
			sel[s_idx] = i;
			combination(i + 1, s_idx + 1, n);
		}
	}
}
