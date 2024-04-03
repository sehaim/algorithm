package SWEA_10761_신뢰;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			int N = sc.nextInt();

			String[] person = new String[N];
			int[] location = new int[N];

			for (int i = 0; i < N; i++) {
				person[i] = sc.next();
				location[i] = sc.nextInt();
			}

			int b_location = 1;
			int o_location = 1;

			int second = 0;
			int b_second = 0;
			int o_second = 0;

			for (int i = 0; i < N; i++) {
				if (person[i].equals("B")) {
					int tmp = Math.abs(location[i] - b_location);
					if (tmp >= o_second) {
						b_second += tmp - o_second + 1;
						second += tmp - o_second + 1;
					} else {
						b_second += 1;
						second += 1;
					}
					o_second = 0;
					b_location = location[i];
				} else {
					int tmp = Math.abs(location[i] - o_location);
					if (tmp >= b_second) {
						o_second += tmp - b_second + 1;
						second += tmp - b_second + 1;
					} else {
						o_second += 1;
						second += 1;
					}
					b_second = 0;
					o_location = location[i];
				}
			}
			System.out.println("#" + t + " " + second);
			t++;
		}
		sc.close();
	}
}
