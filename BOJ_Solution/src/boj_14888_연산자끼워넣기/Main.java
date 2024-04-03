package boj_14888_연산자끼워넣기;

import java.util.Scanner;

public class Main {
	
	public static int N;
	public static int max = Integer.MIN_VALUE;
	public static int min = Integer.MAX_VALUE;
	public static int[] operator = new int[4];
	public static int[] number;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		number = new int[N];
		
		for(int i=0; i<N; i++) {
			number[i] = sc.nextInt();
		}
		
		for(int i=0; i<4; i++) {
			operator[i] = sc.nextInt();
		}
		
		dfs(number[0], 0);
		System.out.println(max);
		System.out.println(min);
		
		sc.close();
	}
	
	public static void dfs(int num, int idx) {
		if(idx == N-1) {
			max = Math.max(num, max);
			min = Math.min(num, min);
		}
		
		for(int i=0; i<4; i++) {
			if(operator[i] > 0) {
				operator[i]--;
				switch(i) {
				case 0 :
					dfs(num + number[idx+1], idx+1);
					break;
				case 1 :
					dfs(num - number[idx+1], idx+1);
					break;
				case 2 :
					dfs(num * number[idx+1], idx+1);
					break;
				case 3 :
					dfs(num / number[idx+1], idx+1);
					break;
				}
				operator[i]++;
			}
		}
	}
}
