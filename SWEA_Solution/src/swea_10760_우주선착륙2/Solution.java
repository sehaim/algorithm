package swea_10760_우주선착륙2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		
		while (t <= T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] arr = new int[N][M];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
			
			int ans = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<M; c++) {
					int cnt = 0;
					for(int d=0; d<8; d++) {
						if(r+dr[d] >= 0 && c+dc[d] >= 0 && r+dr[d] < N && c+dc[d] < M) {
							if(arr[r+dr[d]][c+dc[d]] < arr[r][c]) {
								cnt++;
							}
						}
					}
					if(cnt >= 4) {
						ans++;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
			t++;
		}
		sc.close();
	}
}
