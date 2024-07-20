package boj_1846_장기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[][] arr = new int[N][N];
		
		int idx = 0;
		
		for(int r=0; r<N; r++) {
			arr[r][r+idx] = 1;
			arr[r][N-1-idx] = 1;
			idx++;
		}
		
		
		for(int r=0; r<N; r++) {
			
		}
	}
}
