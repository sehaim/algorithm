package boj_2527_직사각형;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while (tc <= 4) {
			int[] arr1 = new int[4];
			int[] arr2 = new int[4];
			
			for(int i=0; i<arr1.length; i++) {
				arr1[i] = sc.nextInt();
			}
			for(int i=0; i<arr2.length; i++) {
				arr2[i] = sc.nextInt();
			}
			
			char ans = 0;
			if(arr1[2] < arr2[0] || arr2[2] < arr1[0] || arr1[3] < arr2[1] || arr2[3] < arr1[1]) {
				ans = 'd';
			} else if(arr1[0] == arr2[2] || arr1[2] == arr2[0]) {
				if(arr1[1] < arr2[3] && arr1[3] > arr2[1]) {
					ans = 'b';
				} else {
					ans = 'c';
				} 
			} else if(arr1[1] == arr2[3] || arr1[3] == arr2[1]) {
				ans = 'b';
			} else {
				ans = 'a';
			}
			
			System.out.println(ans);
			tc++;
		}
		sc.close();
	}
}
