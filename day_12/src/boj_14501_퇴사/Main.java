package boj_14501_퇴사;

import java.util.Scanner;

public class Main {
	public static int p = 0;
	public static int N;
	public static int[] T;
	public static int[] P;
	public static int max_p = Integer.MIN_VALUE;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = new int[N+1];
		P = new int[N+1];
		
		for(int i=1; i<N+1; i++) {
			T[i] = sc.nextInt();
			P[i] = sc.nextInt();
		}
		
		dfs(p, 1);
		
		System.out.println(max_p);
		sc.close();
	}
	
	public static void dfs(int p, int idx) {
		if(idx == N+1) {
			max_p = Math.max(max_p, p);
			return;
		}
		
		for(int i=idx; i<N+1; i++) {
			if(i == N) {
				if(T[i] == 1) {
					dfs(p+P[i], N+1);
				} else {
					dfs(p, N+1);
				}
			}
			if(T[i] > N-i+1) {
				continue;
			} else {
				dfs(p+P[i], i+T[i]);
			}
		}
	}
}
