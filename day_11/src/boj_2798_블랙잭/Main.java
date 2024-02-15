package boj_2798_블랙잭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		int[] cardArr = new int[N];
		for(int i=0; i<N; i++) {
			cardArr[i] = sc.nextInt();
		}
		
		int max = Integer.MIN_VALUE;
		
		for(int i=0; i<N-2; i++) {
			for(int j=i+1; j<N-1; j++) {
				for(int k=j+1; k<N; k++) {
					int sum = cardArr[i] + cardArr[j] + cardArr[k];
					if(sum <= M && sum > max) {
						max = sum;
					}
				}
			}
		}
		
		System.out.println(max);
		sc.close();
	}
}
