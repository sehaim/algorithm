package boj_3985_롤케이크;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		int N = sc.nextInt();
		
		int[] rollCake = new int[L+1];
		int[] ep = new int[N+1];
		int[] num = new int[N+1];
		
		for(int i=1; i<=N; i++) {
			int num1 = sc.nextInt();
			int num2 = sc.nextInt();
			
			ep[i] = num2-num1;
			
			for(int j=num1; j<=num2; j++) {
				if(rollCake[j] == 0) {
					rollCake[j] = i;
					num[i]++;
				}
			}
		}
		
		int max1 = Integer.MIN_VALUE;
		int max_idx1 = 0;
		int max2 = Integer.MIN_VALUE;
		int max_idx2 = 0;
		
		for(int i=1; i<=N; i++) {
			if(ep[i] > max1) {
				max1 = ep[i];
				max_idx1 = i;
			}
			if(num[i] > max2) {
				max2 = num[i];
				max_idx2 = i;
			}
		}
		
		System.out.println(max_idx1);
		System.out.println(max_idx2);
		
		sc.close();
	}
}
