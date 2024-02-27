package SWEA_4012_요리사;

import java.util.Scanner;

public class Solution {
	static int N, min;
	static int[][] arr;
	static int[] sel1, sel2;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		
		while(t <= T) {
			N = sc.nextInt();
			arr = new int[N][N];
			
			for(int r=0; r<N; r++) {
				for(int c=0; c<N; c++) {
					arr[r][c] = sc.nextInt();
				}
			}
			
			sel1 = new int[N/2];
			sel2 = new int[N/2];
			
			min = Integer.MAX_VALUE;
			combination(0, 0);
			
			System.out.println("#" + t + " " + min);
			t++;
		}
		sc.close();
	}
	
	public static void combination(int idx, int sidx) {
		if(sidx >= N/2) {
			int sum1 = 0;
			for(int i=0; i<N/2-1; i++) {
				for(int j=i; j<N/2; j++) {
					sum1 += (arr[sel1[i]][sel1[j]] + arr[sel1[j]][sel1[i]]);
				}
			}
			int sum2 = calculationSum2();
			int diff = Math.abs(sum1 - sum2);
			min = Math.min(min, diff);
			return;
		}
		
		for(int i=idx; i<=N/2+sidx; i++) {
			sel1[sidx] = i;
			combination(i+1, sidx+1);
		}
	}
	
	public static int calculationSum2() {
		int[] idxArr = new int[N];
		for(int i=0; i<N; i++) {
			idxArr[i] = 1;
		}
		
		for(int i=0; i<N/2; i++) {
			idxArr[sel1[i]] = 0;
		}
		int idx = 0;
		for(int i=0; i<N; i++) {
			if(idxArr[i] != 0) {
				sel2[idx] = i;
				idx++;
			}
		}
		int sum2 = 0;
		for(int i=0; i<N/2-1; i++) {
			for(int j=i; j<N/2; j++) {
				sum2 += (arr[sel2[i]][sel2[j]] + arr[sel2[j]][sel2[i]]);
			}
		}
		return sum2;
	}
}
