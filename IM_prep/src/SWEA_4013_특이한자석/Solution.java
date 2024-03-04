package SWEA_4013_특이한자석;

import java.util.Scanner;

public class Solution {
	static int[][] magnet, pointer;
	static int[] rot = new int[3];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			int K = sc.nextInt();

			for (int r = 0; r < 4; r++) {
				for (int c = 0; c < 8; c++) {
					magnet[r][c] = sc.nextInt();
				}
			}

			pointer = new int[][] { { 0, 2, 6 }, { 0, 2, 6 }, { 0, 2, 6 }, { 0, 2, 6 } };

			for (int i = 0; i < K; i++) {
				int num = sc.nextInt();
				int dir = sc.nextInt();
				switch (num) {
				case 1:
					isequal();
					if (dir == 1) {
						pointer[0][0] -= 2;
						pointer[0][1] -= 2;
						if (pointer[0][0] < 0) {
							pointer[0][0] += 8;
						}
						if (pointer[0][1] < 0) {
							pointer[0][1] += 8;
						}
						if (rot[0] == 1) {
							dir = 2;
						} else {
							break;
						}
					} else if (dir == -1) {
						pointer[0][0] += 2;
						pointer[0][1] += 2;
						if (pointer[0][0] >= 8) {
							pointer[0][0] -= 8;
						}
						if (pointer[0][1] >= 8) {
							pointer[0][1] -= 8;
						}
						if (rot[0] == 1) {
							dir = 2;
						} else {
							break;
						}
					}
				case 2:
					
				}
			}

			t++;
		}
		sc.close();
	}

	public static void isequal( ) {
		for(int r=0; r<3; r++) {
			if(pointer[r][1] != pointer[r+1][2]) {
				rot[r] = 1;
			} else {
				rot[r] = 0;
			}
		}
	}

	public static void rotation(int dir, int ) {
		if(dir == 1) {
			
		}
	}
}
