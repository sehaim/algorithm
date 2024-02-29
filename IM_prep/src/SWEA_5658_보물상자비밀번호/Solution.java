package SWEA_5658_보물상자비밀번호;

import java.util.Arrays;
import java.util.Scanner;

public class Solution {
	static char[] numArr;
	static String[] strArr;
	static char[][] combArr;
	static int num, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;

		while (t <= T) {
			N = sc.nextInt();
			K = sc.nextInt();
			num = N / 4;
			String str = sc.next();
			numArr = str.toCharArray();
			combArr = new char[4][num];
			strArr = new String[N];
			
			int strIdx = 0;
			
			for(int i=0; i<num; i++) {
				combinationNum(i);
				for(int r=0; r<4; r++) {
					for(int c=0; c<num; c++) {
						strArr[strIdx] += combArr[r][c];
					}
					strIdx++;
				}
				for(int c=0; c<num; c++) {
					
				}
				
			}
			System.out.println('B');
			System.out.println(Arrays.toString(strArr));

			System.out.println("#" + t + " ");
			t++;
		}
		sc.close();
	}

	public static void combinationNum(int idx) {
		for (int i = 0; i < 4; i++) {
			int c_idx = 0;
			for (int j = idx + i * num; j < idx + (i + 1) * num; j++) {
				if(j >= N) {
					combArr[i][c_idx] = numArr[j-N];
				} else {
					combArr[i][c_idx] = numArr[j];
				}
				c_idx++;
			}
		}
	}
	
	
	

	public static int changeNum(int[] arr) {
		int sum = 0;
		for(int j=0; j<num; j++) {
			if(arr[j] >= '0' && arr[j] <= '9') {
				sum += arr[j]*Math.pow(16, num-1-j);
			} else {
				switch(arr[j]) {
				case 'A': sum += 10*Math.pow(16, num-1-j); break;
				case 'B': sum += 11*Math.pow(16, num-1-j); break;
				case 'C': sum += 12*Math.pow(16, num-1-j); break;
				case 'D': sum += 13*Math.pow(16, num-1-j); break;
				case 'E': sum += 14*Math.pow(16, num-1-j); break;
				case 'F': sum += 15*Math.pow(16, num-1-j); break;
				}
			}
		}
		return sum;
	}
}
