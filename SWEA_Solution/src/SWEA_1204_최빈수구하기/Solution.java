package SWEA_1204_최빈수구하기;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while(t <= T) {
			int t_num = sc.nextInt();
			int[] score = new int[101];
			
			for(int i=0; i<1000; i++) {
				int idx = sc.nextInt();
				score[idx]++;
			}
			
			int max = Integer.MIN_VALUE;
			int ans = 0;
			
			for(int i=0; i<101; i++) {
				if(score[i] >= max) {
					max = score[i];
					ans = i;
				}
			}
			
			System.out.println("#" + t_num + " " + ans);
			t++;
		}
		sc.close();
	}
}
