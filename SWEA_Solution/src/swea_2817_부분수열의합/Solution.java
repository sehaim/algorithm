package swea_2817_부분수열의합;

import java.util.Scanner;

public class Solution {
	static int N, K, cnt;
	static int[] arr, sel;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;
		while(x <= T) {
			N = sc.nextInt();
			K = sc.nextInt();
			arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			cnt = 0;
			
			for(int num=1; num<=N; num++) {
				sel = new int[num];
				combination(0, 0, num);
			}
			
			System.out.println("#" + x + " " + cnt);
			x++;
		}
		sc.close();
	}
	
	public static void combination(int idx, int sidx, int num) {
		if(sidx >= num) {
			int sum = 0;
			for(int i=0; i<num; i++) {
				sum += sel[i];
			}
			if(sum == K) {
				cnt++;
			}
			return;
		}
		
		for(int i=idx; i<=N-num+sidx; i++) {
			sel[sidx] = arr[i];
			combination(i+1, sidx+1, num);
		}
	}
}
