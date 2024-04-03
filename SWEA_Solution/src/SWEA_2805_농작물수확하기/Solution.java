package SWEA_2805_농작물수확하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		while(tc <= T) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int r=0; r<N; r++) {
				String str = sc.next();
				char[] charArr = str.toCharArray();
				for(int c=0; c<N; c++) {
					arr[r][c] = charArr[c] - '0';
				}
			}
			int ans = 0;
			int lft = N/2;
			int rgt = N/2+1;
			
			for(int r=0; r<N; r++) {
				for(int c=lft; c<rgt; c++) {
					ans += arr[r][c];
				}
				if(r >= N/2) {
					lft++;
					rgt--;
				} else {
					lft--;
					rgt++;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			tc++;
		}
		sc.close();
	}
}
