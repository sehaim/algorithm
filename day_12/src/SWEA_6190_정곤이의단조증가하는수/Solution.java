package SWEA_6190_정곤이의단조증가하는수;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			int N = sc.nextInt();
			int[] arr = new int[N];
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			int max = -1;
			for(int i=0; i<N-1; i++) {
				for(int j=i+1; j<N; j++) {
					max = Math.max(max, search(arr[i]*arr[j]));
				}
			}
			System.out.println("#" + t + " " + max);
			t++;
		}
		sc.close();
	}
	
	public static int search(int num) {
		List<Integer> arrNum = new ArrayList<Integer>();
		int num2 = num;
		while(num2 > 0) {
			arrNum.add(num2 % 10);
			num2 /= 10;
		}
		
		if(arrNum.size() == 1) {
			return -1;
		}
		
		for(int i=0; i<arrNum.size()-1; i++) {
			if(arrNum.get(i) < arrNum.get(i+1)) {
				num = -1;
			}
		}		
		return num;
	}
}
