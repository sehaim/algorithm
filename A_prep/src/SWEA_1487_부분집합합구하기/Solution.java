package SWEA_1487_부분집합합구하기;

import java.util.Scanner;

public class Solution {
	static int N, S, cnt;
	static int[] arr;
	static boolean[] sel;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			N = sc.nextInt();
			S = sc.nextInt();

			arr = new int[N];
			sel = new boolean[N];

			for (int i = 0; i < N; i++) {
				arr[i] = sc.nextInt();
			}

			cnt = 0;
			pow(0, 0);

			System.out.println(cnt);
			t++;
		}
		sc.close();
	}

	public static void pow(int sidx, int sum) {
		if(sum == S) {
			cnt++;
			return;
		}
		if(sidx >= N) {
			return;
		}
		
		pow(sidx+1, sum);
		if(arr[sidx] <= S-sum) {
			pow(sidx+1, sum+arr[sidx]);
		}
	}
}
