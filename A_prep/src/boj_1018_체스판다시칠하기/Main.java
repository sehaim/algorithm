package boj_1018_체스판다시칠하기;

import java.util.Scanner;

public class Main {
	static int[][] arr;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new int[N][M];
		
		
		for(int r=0; r<N; r++) {
			String str = sc.next();
			for(int c=0; c<M; c++) {
				if(str.charAt(c) == 'W') {
					arr[r][c] = 1;
				} else {
					arr[r][c] = 0;
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=0; i<=N-8; i++) {
			for(int j=0; j<=M-8; j++) {
				int cnt = 0;
				
				System.out.println(cnt);
				min = Math.min(min, cnt);
				cnt = 1;
				newArr[i][j] = ~newArr[i][j];
				for(int r=i; r<i+7; r++) {
					for(int c=j; c<j+7; c++) {
						if(newArr[r][c] == newArr[r][c+1]) {
							newArr[r][c+1] = ~newArr[r][c+1];
							cnt++;
						}
						if(newArr[r][c] == newArr[r+1][c]) {
							newArr[r+1][c] = ~newArr[r+1][c];
							cnt++;
						}
					}
				}
				System.out.println(cnt);
				min = Math.min(min, cnt);
			}
		}
		System.out.println(min);
		sc.close();
	}
	
	public static void makeArr(int i, int j) {
		int[][] newArr = new int[8][8];
		int r_idx = 0;
		int c_idx = 0;
		for(int r=i; r<i+7; r++) {
			for(int c=j; c<j+7; c++) {
				newArr[r_idx][c_idx] = arr[r][c];
				c_idx++;
			}
			r_idx++;
		}
	}
	
	public static void calculateCnt(int[][] newArr) {
		int cnt = 0;
		for(int r=0; r<7; r++) {
			for(int c=0; c<7; c++) {
				if(newArr[r][c] == newArr[r][c+1]) {
					cnt
				}
			}
		}
	}
}
