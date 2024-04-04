package swea_1873_상호의배틀필드;

import java.util.Scanner;

public class Solution {
	public static char[][] arr = new char[][] {};
	public static int H;
	public static int W;
	public static int r_idx;
	public static int c_idx;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t =1;
		
		while(t <= T) {
			H = sc.nextInt();
			W = sc.nextInt();
			
			arr = new char[H][W];
			
			for(int r=0; r<H; r++) {
				String str = sc.next();
				arr[r] = str.toCharArray();
			}
			
			r_idx = 0;
			c_idx = 0;
			
			int dir = 0;
			
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					if(arr[r][c] == '<' || arr[r][c] == '>' || arr[r][c] == '^' || arr[r][c] == 'v') {
						r_idx = r;
						c_idx = c;
						switch(arr[r][c]) {
						case '<':
							dir = 3;
							break;
						case '>':
							dir = 4;
							break;
						case '^':
							dir = 1;
							break;
						case 'v':
							dir = 2;
							break;
						}
					}
				}
			}
			
			int N = sc.nextInt();
			String str = sc.next();
			char[] arr2 = str.toCharArray();
			
			
			for(int i=0; i<N; i++) {
				switch(arr2[i]) {
				case 'U':
					dir = 1;
					if(r_idx-1 >= 0 && arr[r_idx-1][c_idx] == '.') {
						arr[r_idx][c_idx] = '.';
						r_idx -= 1;
					}
					arr[r_idx][c_idx] = '^';
					break;
				case 'D':
					dir = 2;
					if(r_idx+1 < H && arr[r_idx+1][c_idx] == '.') {
						arr[r_idx][c_idx] = '.';
						r_idx += 1;
					}
					arr[r_idx][c_idx] = 'v';
					break;
				case 'L':
					dir = 3;
					if(c_idx-1 >= 0 && arr[r_idx][c_idx-1] == '.') {
						arr[r_idx][c_idx] = '.';
						c_idx -= 1;
					}
					arr[r_idx][c_idx] = '<';
					break;
				case 'R':
					dir = 4;
					if(c_idx+1 < W && arr[r_idx][c_idx+1] == '.') {
						arr[r_idx][c_idx] = '.';
						c_idx += 1;
					}
					arr[r_idx][c_idx] = '>';
					break;
				case 'S':
					shoot(dir);
					break;
				}
			}
			
			System.out.print("#" + t + " ");
			
			for(int r=0; r<H; r++) {
				for(int c=0; c<W; c++) {
					System.out.print(arr[r][c]);
				}
				System.out.println();
			}
			t++;
		}
		sc.close();
	}
	
	public static void shoot(int dir) {
		switch(dir) {
		case 1: 
			for(int i=r_idx; i>=0; i--) {
				if(arr[i][c_idx] == '#') {
					return;
				}
				if(arr[i][c_idx] == '*') {
					arr[i][c_idx] = '.';
					return;
				} 
			}
			break;
		case 2:
			for(int i=r_idx; i<H; i++) {
				if(arr[i][c_idx] == '#') {
					return;
				}
				if(arr[i][c_idx] == '*') {
					arr[i][c_idx] = '.';
					return;
				} 
			}
			break;
		case 3:
			for(int i=c_idx; i>=0; i--) {
				if(arr[r_idx][i] == '#') {
					return;
				}
				if(arr[r_idx][i] == '*') {
					arr[r_idx][i] = '.';
					return;
				} 
			}
			break;
		case 4:
			for(int i=c_idx; i<W; i++) {
				if(arr[r_idx][i] == '#') {
					return;
				}
				if(arr[r_idx][i] == '*') {
					arr[r_idx][i] = '.';
					return;
				} 
			}
			break;
		}
	}
}
