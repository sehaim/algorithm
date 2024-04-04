package swea_4613_러시아국기같은깃발;

import java.util.Scanner;

public class Solution {
	public static int cnt;
	public static char[][] arr;
	public static int N;
	public static int M;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char [N][M];
			
			for(int r=0; r<N; r++) {
				String str = sc.next();
				for(int c=0; c<M; c++) {
					arr[r][c] = str.charAt(c);
				}
			}
			
			int min = Integer.MAX_VALUE;
			for(int r1=1; r1<N-1; r1++) {
				for(int r2=r1+1; r2<N; r2++) {
					cnt = 0;
					min = Math.min(calCnt(r1, r2), min);
				}
			}
			System.out.println("#" + t + " " + min);
			t++;
		}
		sc.close();
	}
	
	public static int calCnt(int r1, int r2) {
		for(int r=0; r<N; r++) {
			for(int c=0; c<M; c++) {
				if(r < r1 && arr[r][c] != 'W') {
					cnt++;
				} else if(r >= r1 && r<r2 && arr[r][c] != 'B') {
					cnt++;
				} else if(r >= r2 && arr[r][c] !='R') {
					cnt++;
				}
			}
		}
		return cnt;
	}
}
