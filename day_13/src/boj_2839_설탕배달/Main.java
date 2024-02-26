package boj_2839_설탕배달;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int ans = -1;
		
		int num_5kg = N/5;
		int num_3kg = 0;
		int remain = 0;
		
		for(int i=N/5; i>=0; i--) {
			num_5kg = i;
			remain = N - 5*i;
			if(remain%3 == 0) {
				num_3kg = remain/3;
				ans = num_5kg + num_3kg;
				break;
			}
		}
		
		System.out.println(ans);
		sc.close();
	}
}
