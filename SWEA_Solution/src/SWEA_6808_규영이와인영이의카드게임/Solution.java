package SWEA_6808_규영이와인영이의카드게임;

import java.util.Scanner;

public class Solution {
	static int[] arr1 = new int[9];
	static int[] arr2 = new int[9];
	static int[] result = new int[9];
	static boolean[] visited = new boolean[9];
	static int winNum, looseNum;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;

		while (x <= T) {
			for (int i = 0; i < 9; i++) {
				arr1[i] = sc.nextInt();
			}

			int[] idxArr = new int[19];
			for (int i = 0; i < 9; i++) {
				idxArr[arr1[i]]++;
			}

			int idx = 0;
			for (int i = 1; i < 19; i++) {
				if (idxArr[i] == 0) {
					arr2[idx++] = i;
				}
			}

			winNum = 0;
			looseNum = 0;

			perm(0);

			System.out.println("#" + x + " " + winNum + " " + looseNum);
			x++;
		}
		sc.close();
	}

	public static void perm(int idx) {
		if (idx >= 9) {
			isWin();
			return;
		}

		for (int i = 0; i < 9; i++) {
			if (visited[i])
				continue;
			result[idx] = arr2[i];
			visited[i] = true;
			perm(idx + 1);
			visited[i] = false;
		}
	}

	public static void isWin() {
		int score1 = 0;
		int score2 = 0;
		for (int i = 0; i < 9; i++) {
			if (arr1[i] > result[i]) {
				score1 += (arr1[i] + result[i]);
			} else if (arr1[i] < result[i]) {
				score2 += (result[i] + arr1[i]);
			}
		}

		if (score1 > score2) {
			winNum++;
		} else if (score2 > score1) {
			looseNum++;
		}
	}
}
