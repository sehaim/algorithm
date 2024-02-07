package SWEA_7102_;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if (N == M) {
				int ans = N + 1;
				System.out.println("#" + tc + " " + ans);
			} else if (N > M){
				int[] ans = new int[N-M+1];
				System.out.print("#" + tc + " ");
				for(int i=0; i<ans.length; i++) {
					ans[i] = M+1;
					System.out.print(ans[i] + " ");
					M++;
				}
				System.out.println();
			} else {
				int[] ans = new int[M-N+1];
				System.out.print("#" + tc + " ");
				for(int i=0; i<ans.length; i++) {
					ans[i] = N+1;
					System.out.print(ans[i] + " ");
					N++;
				}
				System.out.println();
			}
			tc++;
		}
		
		sc.close();
	}
}
