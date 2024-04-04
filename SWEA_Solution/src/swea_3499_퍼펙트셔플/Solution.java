package swea_3499_퍼펙트셔플;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		while (tc <= T) {
			int N = sc.nextInt();
			String[] cardArr = new String[N];
			
			for(int i=0; i<N; i++) {
				cardArr[i] = sc.next();
			}
			
			int pointer = 0;
			
			if(N%2 == 0) {
				pointer = N/2;
			} else {
				pointer = N/2 + 1;
			}
			
			String[] newArr = new String[N];
			int idx = 0;
			
			for(int i=0; i<N; i++) {
				if(i%2 == 0) {
					newArr[i] = cardArr[idx];
					idx++;
				} else {
					newArr[i] = cardArr[pointer];
					pointer++;
				}
			}
			System.out.print("#" + tc);
			for(int i=0; i<N; i++) {
				System.out.print(" " + newArr[i]);
			}
			System.out.println();
			tc++;
		}
		sc.close();
	}
}
