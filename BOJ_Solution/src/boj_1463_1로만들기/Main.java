package boj_1463_1로만들기;

import java.util.Scanner;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();

		int cnt = 0;

		while (N > 1) {
			if (N % 6 == 0) {
				N /= 6;
				cnt += 2;
				System.out.println(N);
			} else if (N % 3 == 0) {
				N /= 3;
				cnt++;
				System.out.println(N);
			} else if (N % 2 == 0) {
				N /= 2;
				cnt++;
				System.out.println(N);
			} else {
				N -= 1;
				cnt++;
				System.out.println(N);
			}
		}

		System.out.println(cnt);

		sc.close();
	}
}
// 642 214 107 106 105 35 34 17 16 8 4 2 1