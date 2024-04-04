package swea_5215_햄버거다이어트;

import java.util.Scanner;

public class Solution {
	static int N, L, max_t;
	static int[] t;
	static int[] k;
	static int[] sel_t;
	static int[] sel_k;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		
		while(tc <= T) {
			N = sc.nextInt();
			L = sc.nextInt();
			
			t = new int[N];
			k = new int[N];
			
			for(int i=0; i<N; i++) {
				t[i] = sc.nextInt();
				k[i] = sc.nextInt();
			}
			
			max_t = Integer.MIN_VALUE;
			
			for(int num=1; num<=N; num++) {
				sel_t = new int[num];
				sel_k = new int[num];
				combination(0, 0, num);
			}
			System.out.println("#" + tc + " " + max_t);
			tc++;
		}
		sc.close();
	}
	
	public static void combination(int idx, int sidx, int num) {
		if(sidx >= num) {
			int sum_t = 0;
			int sum_k = 0;
			for(int i=0; i<num; i++) {
				sum_t += sel_t[i];
				sum_k += sel_k[i];
			}
			if(sum_k <= L) {
				max_t = Math.max(max_t, sum_t);
			}
			return;
		}
		
		for(int i=idx; i<=N-num+sidx; i++) {
			sel_t[sidx] = t[i];
			sel_k[sidx] = k[i];
			combination(i+1, sidx+1, num);
		}
	}
}
