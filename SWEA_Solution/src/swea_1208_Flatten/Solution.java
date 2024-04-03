package swea_1208_Flatten;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 0;
		int[] ans = new int[10];
		
		while(tc<10) {
			int t = sc.nextInt();
			int[] arr = new int[100];
			
			for(int i=0; i<100; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<t; i++) {
				int max_idx = searchMax(arr);
				int min_idx = searchMin(arr);
				arr[max_idx] -= 1;
				arr[min_idx] += 1;
			}
			
			int max_idx = searchMax(arr);
			int min_idx = searchMin(arr);
			
			ans[tc] = arr[max_idx] - arr[min_idx];
			tc++;
		}
		
		for(int i=0; i<10; i++) {
			System.out.println("#" + (i+1) + " " + ans[i]);
		}
		sc.close();
	}
	
	public static int searchMin(int[] arr) {
		int min = Integer.MAX_VALUE;
		int min_idx = 0;
		for(int i=0; i<100; i++) {
			if(arr[i] < min) {
				min = arr[i];
				min_idx = i;
			}
		}
		return min_idx;
	}
	
	public static int searchMax(int[] arr) {
		int max = Integer.MIN_VALUE;
		int max_idx = 0;
		for(int i=0; i<100; i++) {
			if(arr[i] > max) {
				max = arr[i];
				max_idx = i;
			}
		}
		return max_idx;
	}

}
