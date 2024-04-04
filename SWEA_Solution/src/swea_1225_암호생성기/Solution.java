package swea_1225_암호생성기;

import java.util.Scanner;

public class Solution {
	public static int[] pw = new int[8];
	public static int pointer;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while (tc<=10) {
			int T = sc.nextInt();
			for(int i=0; i<pw.length; i++) {
				pw[i] = sc.nextInt();
			}
			pointer = -1;
			
			int stop = 0;
			int pointer2 = 0;
			while (stop == 0) {
				for(int i=1; i<=5; i++) {
					int bf = cycle(i);
					if(isZero(bf)) {
						pw[pointer] = 0;
						pointer2 = pointer;
						stop = 1;
						break;
					}
				}
			} 
			
			int[] newPW = swap(pointer2);
			
			System.out.print("#" + T + " ");
			for (int i=0; i<newPW.length; i++) {
				System.out.print(newPW[i] + " ");
			}
			
			System.out.println();
			tc++;
		}
		sc.close();
	}
	
	
	public static int cycle(int i) {
		if(pointer == 7) {
			pointer = -1;
		}
		return pw[++pointer] -= i;
	}
	
	public static boolean isZero(int num) {
		return num <= 0;
	}
	
	public static int[] swap(int num) {
		int[] arr = new int[8];
		int j = 0;
		for(int i=num+1; i<arr.length; i++) {
			arr[j++] = pw[i];
		}
		for(int i=0; i<=num; i++) {
			arr[j++] = pw[i];
		}
		
		return arr;
		
	}
}
