package boj_14696_딱지놀이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int n = 1;
		while(n <= N) {
			
			int[] cardA = new int[5];
			int[] cardB = new int[5];
			
			for(int i=0; i<2; i++) {
				int len = sc.nextInt();
				for(int j=0; j<len; j++) {
					if(i == 0) {
						cardA[sc.nextInt()]++;
					}
					else {
						cardB[sc.nextInt()]++;
					}
				}
			}
			
			char result = 'D';
			
			for(int i=4; i>0; i--) {
				if(cardA[i] == cardB[i]) {
					continue;
				} else {
					if(cardA[i] > cardB[i]) {
						result = 'A';
						break;
					} else {
						result = 'B';
						break;
					}
				}
			}
			
			System.out.println(result);
			n++;
		}
		sc.close();
	}
}
