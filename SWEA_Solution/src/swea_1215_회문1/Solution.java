package swea_1215_회문1;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[8][8];
		int tc = 1;
		
		while(tc <= 10) {
			int len = sc.nextInt();
			for(int r=0; r<8; r++) {
				String text = sc.next();
				arr[r] = text.toCharArray();
			}
			
			int sum = 0;
			for(int r=0; r<8; r++) {
				sum += searchSum(arr[r], len);
			}
			
			for(int c=0; c<8; c++) {
				sum += searchSum(newArray(arr,c), len);
			}
			
			System.out.println("#" + tc + " " + sum);
			tc++;
		}
			sc.close();
	}
	
	public static int searchSum(char[] arr, int len) {
		int sum = 0;

		search: for(int i=0; i<arr.length-(len-1); i++) {
			for(int idx=0; idx<=(len-1)/2; idx++) {
				if(arr[i+idx] != arr[i+len-1-idx]) {
					continue search;
				}
			}
			sum++;
		}
		return sum;
	}

	public static char[] newArray(char[][] arr, int c) {
		char[] newArr = new char[8];
		int i = 0;
		for(int r=0; r<8; r++) {
			newArr[i++] = arr[r][c];
		}
		return newArr;
	}
}
