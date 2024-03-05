package SWEA_4013_특이한자석;

import java.util.Scanner;

public class Solution {
	static int[][] magnet, pointer;
	static int[] equalArr = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			int K = sc.nextInt();
			magnet = new int[4][8];

			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 8; c++) {
					magnet[r][c] = sc.nextInt();
				}
			}

			pointer = new int[][] { { 0, 2, 6 }, { 0, 2, 6 }, { 0, 2, 6 }, { 0, 2, 6 } };

			for (int i = 0; i < K; i++) {
				equalArr = new int[3];
				for (int j = 0; j < 3; j++) {
					if (magnet[j][pointer[j][1]] == magnet[j + 1][pointer[j + 1][2]]) {
						equalArr[j] = 1;
					}
				}

				int num = sc.nextInt();
				int dir = sc.nextInt();
				rotation(dir, num);
			}

			int ans = 0;

			for (int i = 0; i < 4; i++) {
				if (magnet[i][pointer[i][0]] == 1) {
					ans += Math.pow(2, i);
				}
			}

			System.out.println("#" + t + " " + ans);
			t++;
		}
		sc.close();
	}

	public static void rotation(int dir, int num) {
		int num_dir = dir;
		direction(num_dir, num);

		for (int i = 1; i < 4; i++) {
			if (num - i > 0 && equalArr[num - i - 1] == 0) {
				if (dir == 1) {
					dir = -1;
				} else if (dir == -1) {
					dir = 1;
				}
				direction(dir, num - i);
			} else {
				break;
			}
		}
		
		dir = num_dir;
		
		for (int i = 0; i < 3; i++) {
			if (num + i < 4 && equalArr[num + i - 1] == 0) {
				if (dir == 1) {
					dir = -1;
				} else if (dir == -1) {
					dir = 1;
				}
				direction(dir, num + i + 1);
			} else {
				break;
			}
		}
	}

	public static void direction(int dir, int num) {
		if (dir == -1) {
			for (int i = 0; i < 3; i++) {
				pointer[num - 1][i] += 1;
				if (pointer[num - 1][i] >= 8) {
					pointer[num - 1][i] -= 8;
				}
			}
		} else if (dir == 1) {
			for (int i = 0; i < 3; i++) {
				pointer[num - 1][i] -= 1;
				if (pointer[num - 1][i] < 0) {
					pointer[num - 1][i] += 8;
				}
			}
		}
	}
}
