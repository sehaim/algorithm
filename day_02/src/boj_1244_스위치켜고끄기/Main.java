package boj_1244_스위치켜고끄기;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[sc.nextInt()];
		for (int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int tc = sc.nextInt();
		int t = 0;
		
		while(t<tc) {
			int gender = sc.nextInt();
			int M =sc.nextInt();
			
			if(gender == 1) {
				arr = manSwitch(M, arr);
			} else if(gender == 2) {
				arr = womanSwitch(M, arr);
			}
			t++;
		}

		for(int i=0; i<arr.length; i++) {
			System.out.print(arr[i]+" ");
			for(int j=0; j<5; j++)
				if(i+1 == j*20) {
					System.out.println();
				}
		}
		sc.close();
	}
	
	public static int[] womanSwitch(int M, int[] arr) {
		int lft = 1;
		int rgt = 1;
		M = M-1;
		if(arr[M] == 1) {
			arr[M] = 0;
		} else {
			arr[M] = 1;
		}
		
		for(int i=0; i<arr.length/2; i++) {
			if(lft<=M && M+rgt<arr.length) {
				if(arr[M-lft] == arr[M+rgt]) {
					if(arr[M-lft] == 1) {
						arr[M-lft] = 0;
						arr[M+rgt] = 0;
					} else {
						arr[M-lft] = 1;
						arr[M+rgt] = 1;
					}
				} else {
					break;
				}
			}
			lft++;
			rgt++;
		}
		return arr;
	}
	
	public static int[] manSwitch(int M, int[] arr) {
		for(int j=0; (M-1+j*M)<arr.length; j++) {
				if(arr[M-1+j*M] == 1) {
					arr[M-1+j*M] = 0;
				} else if(arr[M-1+j*M] == 0) {
					arr[M-1+j*M] = 1;
				}
		}
		return arr;
	}

}
