package SWEA_4014_활주로건설;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		
		while(t <= T) {
			int N = sc.nextInt();
			int X = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int cnt = 0;
			
			label1: for(int r=0; r<N; r++) {
				label2: for(int c=0; c<N-1; c++) {
					if((Math.abs(arr[r][c] - arr[r][c+1])) == 1) {
						int max = Math.max(arr[r][c], arr[r][c+1]);
						int dir = 0;
						if(max == arr[r][c]) {
							dir = 1;
						} else {
							dir = -1;
						}
						
						switch(dir) {
						case 1:
							for(int c2=c+1; c2<=c+X; c2++) {
								if(c+X >= N || (arr[r][c2] != arr[r][c] - 1)) {
									continue label1;
								}
							}
							if((c+X < N-1) && (arr[r][c+X] < arr[r][c+X+1])) {
								continue label1;
							}
							c = c + X - 1;
							continue label2;
						case -1:
							for(int c2=c; c2>=c-X+1; c2--) {
								if(c-X+1 < 0 || (arr[r][c2] != arr[r][c+1] - 1)) {
									continue label1;
								}
							}
							continue label2;
						}
					} else if((Math.abs(arr[r][c] - arr[r][c+1])) > 1) {
						continue label1;
					}
				}
				cnt++;
			}
			
			label3: for(int c=0; c<N; c++) {
				label4: for(int r=0; r<N-1; r++) {
					if((Math.abs(arr[r][c] - arr[r+1][c])) == 1) {
						int max = Math.max(arr[r][c], arr[r+1][c]);
						int dir = 0;
						if(max == arr[r][c]) {
							dir = 1;
						} else {
							dir = -1;
						}
						
						switch(dir) {
						case 1:
							for(int r2=r+1; r2<=r+X; r2++) {
								if(r+X >= N || (arr[r2][c] != arr[r][c] - 1)) {
									continue label3;
								}
							}
							if((r+X < N-1) && (arr[r+X][c] < arr[r+X+1][c])) {
								continue label3;
							}
							r = r + X - 1;
							continue label4;
						case -1:
							for(int r2=r; r2>=r-X+1; r2--) {
								if(r-X+1 < 0 || (arr[r2][c] != arr[r+1][c] - 1)) {
									continue label3;
								}
							}
							continue label4;
						}
					} else if((Math.abs(arr[r][c] - arr[r+1][c])) > 1) {
						continue label3;
					}
				}
				cnt++;
			}
			
			System.out.println("#" + t + " " + cnt);
			t++;
		}
		
		sc.close();
	}
}
