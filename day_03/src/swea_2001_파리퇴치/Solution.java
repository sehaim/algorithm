package swea_2001_파리퇴치;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 0;
		while(tc < T) {
			int N = sc.nextInt();
			int[][] arr = new int[N][N];
			int M = sc.nextInt();
			int i = 0;
			int[] sumArr = new int[(N-M+1)*(N-M+1)];
			
			for (int r=0; r<N; r++) {
				for (int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			for (int r=0; r<=N-M; r++) {
				for (int c=0; c<=N-M; c++) {
					sumArr[i++] = calculateSum(arr, r, c, M);
				}
			}
			
			int max = searchMax(sumArr);
			System.out.println("#" + (tc+1) + " " + max);
			tc++;
		}
		
		sc.close();
	}
	
	public static int calculateSum(int[][] arr, int r, int c, int M) {
		int sum = 0;
		for(int r2=r; r2<r+M; r2++) {
			for(int c2=c; c2<c+M; c2++) {
				sum += arr[r2][c2];
			}
		}
		return sum;
	}
	
	public static int searchMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		for(int i=0; i<arr.length; i++) {
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		return max;
	}
}
