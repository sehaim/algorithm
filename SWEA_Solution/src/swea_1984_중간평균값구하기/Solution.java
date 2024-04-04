package swea_1984_중간평균값구하기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while(t <= T) {
			int[] arr = new int[10];
			for(int i=0; i<10; i++) {
				arr[i] = sc.nextInt();
			}
			
			Arrays.sort(arr);
			
			arr[0] = 0;
			arr[9] = 0;
			
			int sum = 0;
			
			for(int i=1; i<9; i++) {
				sum += arr[i];
			}
			
			double avg = (double) sum/8;
			
			System.out.printf("#%d %1.0f \n", t, avg);
			t++;
		}
		sc.close();
	}
}
