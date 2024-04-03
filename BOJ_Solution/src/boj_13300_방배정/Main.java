package boj_13300_방배정;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] stdArr = new int[2][7];
		
		for(int i=0; i<N; i++) {
			int gender = sc.nextInt();
			int grade = sc.nextInt();
			stdArr[gender][grade]++;
		}
		
		int room = 0;
		
		for(int r=0; r<2; r++) {
			for(int c=1; c<7; c++) {
				if(stdArr[r][c]%K == 0) {
					room += stdArr[r][c]/K;
				} else {
					room += stdArr[r][c]/K + 1;
				}
			}
		}
		System.out.println(room);
		sc.close();
	}

}
