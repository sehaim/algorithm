package swea_14510_나무높이;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			int N = sc.nextInt();
			int[] treeArr = new int[N];

			for (int i = 0; i < N; i++) {
				treeArr[i] = sc.nextInt();
			}

			Arrays.sort(treeArr);

			int odd = 0;
			int even = 0;

			for (int i = 0; i < N; i++) {
				treeArr[i] = treeArr[N - 1] - treeArr[i];
				odd += treeArr[i] % 2;
				even += treeArr[i] / 2;
			}

			while (odd < even) {
				even--;
				odd += 2;
			}

			int ans = odd * 2;

			System.out.println("#" + t + " " + ans);
			t++;
		}

		sc.close();
	}
}
