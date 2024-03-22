package boj_1018_체스판다시칠하기;

import java.util.Scanner;

public class Main {
	static char[][] arr;
	static int min;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		arr = new char[N][M];
		
		for(int r=0; r<N; r++) {
			String str = sc.next();
			arr[r] = str.toCharArray();
		}
		
		min = Integer.MAX_VALUE;

		for (int r = 0; r <= N - 8; r++) {
			for (int c = 0; c <= M - 8; c++) {
				createNewArr(r, c);
			}
		}
		
		System.out.println(min);
		sc.close();
	}

	public static void createNewArr(int r_idx, int c_idx) {
		char[][] newArr = new char[8][8];
		int r2 = 0;
		int c2 = 0;

		for (int r = r_idx; r < r_idx + 8; r++) {
			c2=0;
			for (int c = c_idx; c < c_idx + 8; c++) {
				newArr[r2][c2] = arr[r][c];
				c2++;
			}
			r2++;
		}
		min = Math.min(dfs(newArr, 'W', 'B'), min);
		min = Math.min(dfs(newArr, 'B', 'W'), min);
	}
	
	public static int dfs(char[][] newArr, char ch, char ch_rv) {
		int cnt = 0;
		
		for(int r=0; r<8; r++) {
			for(int c=0; c<8; c++) {
				if(c%2 == 0 && newArr[r][c] != ch) {
					cnt++;
				}
				else if(c%2 == 1 && newArr[r][c] != ch_rv) {
					cnt++;
				}
			}
			char tmp = ch;
			ch = ch_rv;
			ch_rv = tmp;
		}
		return cnt;
	}
}