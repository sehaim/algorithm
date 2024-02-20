package boj_10163_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[1001][1001];
		int N = sc.nextInt();
		int n = 1;
		
		while(n <= N) {
			int r_idx = sc.nextInt();
			int c_idx = sc.nextInt();
			int w = sc.nextInt();
			int h = sc.nextInt();
			
			for(int r=r_idx; r<r_idx+w; r++) {
				for(int c=c_idx; c<c_idx+h; c++) {
					arr[r][c] = n;
				}
			}
			n++;
		}
		
		for(int i=1; i<=N; i++) {
			int ans = 0;
			for(int r=0; r<1001; r++) {
				for(int c=0; c<1001; c++) {
					if(arr[r][c] == i) {
						ans++;
					}
				}
			}
			System.out.println(ans);
		}
		sc.close();
	}
}
