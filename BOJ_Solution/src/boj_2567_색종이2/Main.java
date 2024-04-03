package boj_2567_색종이2;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] arr = new int[102][102];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] c_idx = new int[N];
		int[] r_idx = new int[N];
		
		for(int i=0; i<N; i++) {
			c_idx[i] = sc.nextInt();
			r_idx[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int c=c_idx[i]+1; c<c_idx[i]+11; c++) {
				for(int r=91-r_idx[i]; r<101-r_idx[i]; r++) {
					arr[r][c] = 1;
				}
			}
		}
		
		int[] dr = {-1, 1, 0, 0};
		int[] dc = {0, 0, -1, 1};
		int ans = 0;
		
		for(int r=0; r<102; r++) {
			for(int c=0; c<102; c++) {
				if(arr[r][c] == 0) {
					for(int d=0; d<4; d++) {
						if(r+dr[d]>=0 && r+dr[d]<102 && c+dc[d]>=0 && c+dc[d]<102) {
							if(arr[r+dr[d]][c+dc[d]] == 1) {
								ans += 1;
							}
						}
					}
				}
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
