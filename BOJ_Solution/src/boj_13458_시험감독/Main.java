package boj_13458_시험감독;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] A = new int[N];
		
		for(int i=0; i<N; i++) {
			A[i] = sc.nextInt();
		}
		
		int B = sc.nextInt();
		int C = sc.nextInt();
		long cnt = 0;
		
		for(int i=0; i<N; i++) {
			if(A[i] == 0) {
				continue;
			}
			A[i] -= B;
			cnt++;
		}
		
		for(int i=0; i<N; i++) {
			if(A[i]>0) {
				cnt += A[i]/C;
				if(A[i]%C > 0) {
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		sc.close();
	}
}
