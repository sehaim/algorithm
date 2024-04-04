package swea_1970_쉬운거스름돈;

import java.util.Scanner;

public class Solution {
	static int[] money = { 50000, 10000, 5000, 1000, 500, 100, 50, 10 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			int N = sc.nextInt();
			int[] moneyCnt = new int[8];

			for (int i = 0; i < 8; i++) {
				moneyCnt[i] = N / money[i];
				N = N % money[i];
			}

			System.out.println("#" + t);
			for (int i = 0; i < 8; i++) {
				System.out.print(moneyCnt[i] + " ");
			}
			System.out.println();
			t++;
		}
		sc.close();
	}
}
