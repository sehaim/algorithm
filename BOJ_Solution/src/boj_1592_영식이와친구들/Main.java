package boj_1592_영식이와친구들;

import java.util.Scanner;

class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int L = sc.nextInt();
		int cnt = 1;
		int[] arr = new int[N];
		arr[0] = 1;
		arr[L] = 1;
		int i = L;
		
		while (arr[0] < 2) {
			i = (i+L)%N;
			arr[i] += 1;
			cnt++;
		}
		
		cnt = (M-1)*cnt;
		System.out.println(cnt);
		sc.close();
	}
}