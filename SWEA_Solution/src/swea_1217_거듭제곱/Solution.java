package swea_1217_거듭제곱;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = 1;
		
		while(t <= 10) {
			t = sc.nextInt();
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			System.out.println("#" + t + " " + pow(N, M));
			t++;
		}
		sc.close();
	}
	
	public static int pow(int N, int M) {
		if(M <= 1) return N;
		
		int tmp = 0;
		tmp = pow(N, M/2);
		if(M%2 == 0) {
			return tmp * tmp;
		} else {
			return tmp * tmp * N;
		}
	}
}
