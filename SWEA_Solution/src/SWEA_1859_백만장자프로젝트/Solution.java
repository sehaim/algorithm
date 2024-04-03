package SWEA_1859_백만장자프로젝트;

import java.util.Scanner;

public class Solution {
	public static int[] arr;
	public static long gain;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;
		while(x <= T) {
			int N = sc.nextInt();
			arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			gain = 0;
			calculateGain(0);
			System.out.println("#" + x + " " + gain);
			x++;
		}
		sc.close();
	}
	
	public static void calculateGain(int idx) {
		if(idx >= arr.length-1) {
			return;
		}
		int max = Integer.MIN_VALUE;
		int max_idx = 0;
		long buy = 0;
		int buy_cnt = 0;
		for(int i=idx; i<arr.length; i++) {
			if(arr[i] > max) {
				max = arr[i];
				max_idx = i;
			}
		}
		if(max_idx == idx) {
			calculateGain(max_idx+1);
		} else {
			for(int i=idx; i<max_idx; i++) {
				buy_cnt++;
				buy += arr[i];
			}
			gain += arr[max_idx] * buy_cnt - buy;
			calculateGain(max_idx+1);
		}
	}
}
