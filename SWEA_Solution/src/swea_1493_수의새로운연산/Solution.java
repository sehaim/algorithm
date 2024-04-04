package swea_1493_수의새로운연산;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		
		while(t <= T) {
			int p = sc.nextInt();
			int q = sc.nextInt();
			
			int[] p_idx = searchLocation(p);
			int[] q_idx = searchLocation(q);
			
			int[] ans_idx = {p_idx[0] + q_idx[0], p_idx[1] + q_idx[1]};

			System.out.println("#" + t + " " + searchAns(ans_idx));
			
			t++;
		}
		sc.close();
	}
	
	public static int[] searchLocation(int num) {
		int[] arr = new int[2];
		int i = 0;
		int sum = 0;
		while(num > sum) {
			i++;
			sum += i;
		}
		
		int diff = sum-num;
		arr[0] = 1 + diff;
		arr[1] = i - diff;
		return arr;
	}
	
	public static int searchAns(int[] arr) {
		int diff = arr[0] - 1;
		arr[1] += diff;
		
		int i = 0;
		int sum = 0;
		
		while(i < arr[1]) {
			i++;
			sum += i;
		}
		
		return sum - diff;
	}
}
