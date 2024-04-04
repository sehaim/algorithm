package swea_4466_최대성적표만들기;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		
		while(t <= T) {
			int N = sc.nextInt();
			int K = sc.nextInt();
			int[] scoreArr = new int[N];
			
			for(int i=0; i<N; i++) {
				scoreArr[i] = sc.nextInt();
			}
			
			Arrays.sort(scoreArr);
			int sum = 0;
			for(int i=N-1; i>=N-K; i--) {
				sum += scoreArr[i];
			}
			
			System.out.println("#" + t + " " + sum);
			t++;
		}
		sc.close();
	}
}
