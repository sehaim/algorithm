package boj_2563_색종이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int[][] arr = new int[100][100];
		
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int[] c_idx = new int[N];
		int[] r_idx = new int[N];
		
		for(int i=0; i<N; i++) {
			c_idx[i] = sc.nextInt();
			r_idx[i] = sc.nextInt();
		}
		
		for(int i=0; i<N; i++) {
			for(int c=c_idx[i]; c<c_idx[i]+10; c++) {
				for(int r=90-r_idx[i]; r<100-r_idx[i]; r++) {
					arr[r][c] = 1;
				}
			}
		}
		
		int ans = 0;
		
		for(int r=0; r<100; r++) {
			for(int c=0; c<100; c++) {
				if(arr[r][c] == 1) {
					ans += 1;
				}
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
