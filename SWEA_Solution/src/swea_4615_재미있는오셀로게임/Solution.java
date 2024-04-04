package swea_4615_재미있는오셀로게임;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		
		while(t <= T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			int[][] arr = new int[N][N];
			
			arr[N/2-1][N/2-1] = arr[N/2][N/2] = 2;
			arr[N/2-1][N/2] = arr[N/2][N/2-1] = 1;
			
			int[] dr = {-1, -1, -1, 0, 0, 1, 1, 1};
			int[] dc = {-1, 0, 1, -1, 1, -1, 0, 1};
			
			for(int i=0; i<M; i++) {
				int c = sc.nextInt()-1;
				int r = sc.nextInt()-1;
				int color = sc.nextInt();
				arr[r][c] = color;
				int rvColor;
				
				if(color == 1) {
					rvColor = 2;
				} else {
					rvColor = 1;
				}
				
				label1 : for(int d=0; d<8; d++) {
					int j_idx=-1;

					for(int j=1; j<N; j++) {
						int nr = r + dr[d]*j;
						int nc = c + dc[d]*j;
						if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
							if(arr[nr][nc] == 0) {
								break;
							} else if(arr[nr][nc] == color) {
								j_idx = j;
								break;
							}
						}
					}
					if(j_idx <= 1) {
						continue label1;
					} else {
						for(int k=1; k<j_idx; k++) {
							int nr = r + dr[d]*k;
							int nc = c + dc[d]*k;
							if(nr >= 0 && nc >= 0 && nr < N && nc < N) {
								arr[nr][nc] = color;
								}
							}
						}
					}
					
				}
			int blackCnt = 0;
			int whiteCnt = 0;
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					if(arr[r][c] == 1) {
						blackCnt++;
					} else if(arr[r][c] == 2) {
						whiteCnt++;
					}
				}
			}
			
			System.out.println("#" + t + " " + blackCnt + " " + whiteCnt);
			t++;
		}
		sc.close();
	}
}
