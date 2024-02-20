package boj_2851_슈퍼마리오;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] mushroom = new int[10];
		for(int i=0; i<10; i++) {
			mushroom[i] = sc.nextInt();
		}
		int ans = 0;
		int score = 0;
		
		for(int i=0; i<10; i++) {
			score += mushroom[i];
			if(score >= 100) {
				int tmp = score - mushroom[i];
				int diff1 = Math.abs(tmp-100);
				int diff2 = Math.abs(score-100);
				if(diff1 >= diff2) {
					ans = score;
					break;
				} else {
					ans = tmp;
					break;
				}
			} else {
				ans = score;
			}
		}
		System.out.println(ans);
		sc.close();
	}
}
