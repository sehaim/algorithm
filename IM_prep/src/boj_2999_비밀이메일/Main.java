package boj_2999_비밀이메일;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] arr = str.toCharArray();
		
		int R = 0;
		int C = 0;
		
		for(int i=1; i<=arr.length/2; i++) {
			if (arr.length%i == 0 && i <= arr.length/i) {
				R = i;
				C = arr.length/i;
			}
		}
		
		for(int r=0; r<R; r++) {
			for(int c=0; c<C; c++) {
				System.out.print(arr[r + c*R]);
			}
		}

		sc.close();
	}
}
