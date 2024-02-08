package SWEA_1860_Áø±âÀÇ;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		while(tc <= T) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					if(arr[i] > arr[j]) {
						int tmp = arr[i];
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
			
			int cnt = 0;
			int idx = 0;
			String result = "Possible";
			
			if(arr[0] < M) {
				result = "Impossible";
			} else {
				for(int i=1; i<=arr[N-1]; i++) {
					if(i%M == 0) {
						cnt += K;
					}
					if(i == arr[idx]) {
						cnt -= 1;
						idx++;
						if(idx > N) {
							break;
						}
					}
					if(cnt < 0) {
						result = "Impossible";
						break;
					}
				}
			}
			
			System.out.println("#" + tc + " " + result);
			tc++;
		}
		
		sc.close();
	}
}
