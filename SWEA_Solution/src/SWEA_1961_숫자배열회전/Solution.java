package SWEA_1961_숫자배열회전;

import java.util.Scanner;

public class Solution {
	public static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while(t <= T) {
			N = sc.nextInt();
			int[][] arr = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			int[][] newArr1 = rotate(arr);
			int[][] newArr2 = rotate(newArr1);
			int[][] newArr3 = rotate(newArr2);
			
			System.out.println("#" + t);
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					System.out.print(newArr1[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					System.out.print(newArr2[r][c]);
				}
				System.out.print(" ");
				for(int c=0; c<N; c++) {
					System.out.print(newArr3[r][c]);
				}
				System.out.println();
			}
			t++;
		}
		sc.close();
	}
	
	public static int[][] rotate(int[][] arr) {
		int newArr[][] = new int[N][N];
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				newArr[c][N-1-r] = arr[r][c];
			}
		}
		return newArr;
	}
}
