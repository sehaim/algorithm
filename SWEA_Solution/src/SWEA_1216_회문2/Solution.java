package SWEA_1216_회문2;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[][] arr = new char[100][100];
		int tc = 0;
		
		while(tc <= 10) {
			tc = sc.nextInt();
			for(int r=0; r<100; r++) {
				String text = sc.next();
				arr[r] = text.toCharArray();
			}
			
			int ans = Integer.MIN_VALUE;
			for(int r=0; r<100; r++) {
				int len = searchLength(arr[r]);
				if(len>ans) {
					ans = len;
				}
			}
			
			for(int c=0; c<100; c++) {
				
				int len = searchLength(newArray(arr,c));
				if(len>ans) {
					ans = len;
				}
			}
			
			System.out.println("#" + tc + " " + ans);
			tc++;
		}
			sc.close();
	}
	
	public static int searchLength(char[] arr) {
		int num1 =0;
		int num2 =0;
		int len = 1;
		for(int i=0; i<arr.length-1; i++) {
			search: for(int idx=i+1; idx<arr.length; idx++) {
				if(arr[i] == arr[idx]) {
					for(int k=0; k<=(idx-i)/2; k++) {
						if(arr[i+k] != arr[idx-k]) {
							continue search;
						}
					}
					num1 = i;
					num2 = idx;
					
					if((num2-num1+1)>len) {
						len = num2-num1+1;
					}
				}
			}
		}
		return len;
	}
	
	public static char[] newArray(char[][] arr, int c) {
		char[] newArr = new char[100];
		int i = 0;
		for(int r=0; r<100; r++) {
			newArr[i++] = arr[r][c];
		}
		return newArr;
	}
}
