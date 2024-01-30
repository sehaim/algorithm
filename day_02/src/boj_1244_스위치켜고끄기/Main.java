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
		int t = 1;
		
		while(t<=tc) {
			int gender = sc.nextInt();
			int M =sc.nextInt();
			
			if(gender == 1) {
				arr = manSwitch(M, arr);
			} else if(gender == 2) {
				arr = womanSwitch(M, arr);
			}
			
		}
		
		System.out.println();
	}
	
	public static int[] womanSwitch(int M, int[] arr) {
		int num1 =0;
		int num2 =0;
		M = M-1;
		for(int i=0; i<arr.length; i++) {
			if(i<=M && M+i<arr.length) {
				if(arr[M-i] != arr[M+i]) {
					num1 = M-i;
					num2 = M+i;
					break;
				}
			}
		}
		for(int i=num1+1; i<num2; i++) {
			if(arr[i] == 1) {
				arr[i] = 0;
			} else if(arr[i] == 0) {
				arr[i] = 1;
			}
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
