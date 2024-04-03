package boj_1158_요세푸스문제;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int K = sc.nextInt();
		
		int[] arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		int pointer = K-1;
		int[] newArr = new int[N];
		
		for(int i=0; i<N; i++) {
			newArr[i] = arr[pointer];
			arr[pointer] = 0;
			int cnt = 0;
			for(int j=0; j<=N*K; j++) {
				if(pointer+1 >=N) {
					pointer = pointer - N;
				}
				pointer++;
				if(arr[pointer] != 0) {
					cnt++;
				}
				if(cnt == K) {
					break;
				}
			}
		}
		
		System.out.print("<" + newArr[0]);
		for(int i=1; i<N; i++) {
			System.out.print(", " + newArr[i]);
			
		}

		System.out.print(">");
		System.out.println();
		sc.close();
	}
}
