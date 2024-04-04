package swea_1954_달팽이숫자;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while(t <= T) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			int dir = 0;
			int lft = 0;
			int rgt = N-1;
			int top = 0;
			int bottom = N-1;
			int num = 1;

			while (num <= N*N) {
				switch(dir) {
				case 0 :
					for(int c=lft; c<=rgt; c++) {
						arr[top][c] = num++;
					}
					dir = 1;
					top++;
					break;
				case 1 :
					for(int r=top; r<=bottom; r++) {
						arr[r][rgt] = num++;
					}
					dir = 2;
					rgt--;
					break;
				case 2 :
					for(int c=rgt; c>=lft; c--) {
						arr[bottom][c] = num++;
					}
					dir = 3;
					bottom--;
					break;
				case 3 :
					for(int r=bottom; r>=top; r--) {
						arr[r][lft] = num++;
					}
					dir = 0;
					lft++;
					break;
				}
			}
			
			System.out.println("#" + t);
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(arr[r][c] + " ");
				}
				System.out.println();
			}
			t++;
		}
		sc.close();
	}
}
