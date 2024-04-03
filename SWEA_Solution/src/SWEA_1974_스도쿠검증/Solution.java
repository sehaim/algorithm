package SWEA_1974_스도쿠검증;

import java.util.Scanner;

public class Solution {
	public static int ans;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		label : while(t <= T) {
			int[][] arr = new int[9][9];
			for(int r=0; r<9; r++) {
				for(int c=0; c<9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			ans = 1;
			
			for(int r=0; r<9; r++) {
				int[] checkArr = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
				for(int c=0; c<9; c++) {
					checkArr[arr[r][c]] -= 1;
				}
				result(checkArr);
				if(ans == 0) {
					System.out.println("#" + t + " " + ans);
					t++;
					continue label;
				}
			}
			
			for(int c=0; c<9; c++) {
				int[] checkArr = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
				for(int r=0; r<9; r++) {
					checkArr[arr[r][c]] -= 1;
				}
				result(checkArr);
				if(ans == 0) {
					System.out.println("#" + t + " " + ans);
					t++;
					continue label;
				}
			}
			
			for(int r=0; r<3; r++) {
				for(int c=0; c<3; c++) {
					smallSearch(arr, 3*r, 3*c);
					if(ans == 0) {
						System.out.println("#" + t + " " + ans);
						t++;
						continue label;
					}
				}
			}
			
			System.out.println("#" + t + " " + ans);
			t++;
		}
		sc.close();
	}
	
	public static void result(int[] arr) {
		for(int i=0; i<10; i++) {
			if(arr[i] != 0) {
				ans = 0;
				return;
			}
		}
	}
	
	public static void smallSearch(int[][] arr, int i, int j) {
		int[] checkArr = new int[] {0, 1, 1, 1, 1, 1, 1, 1, 1, 1};
		for(int r=i; r<i+3; r++) {
			for(int c=j; c<j+3; c++) {
				checkArr[arr[r][c]] -= 1;
			}
		}
		result(checkArr);
	}
}
