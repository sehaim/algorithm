package boj_2810_컵홀더;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		char[] arr = new char[N];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = str.charAt(i);
		}
		
		int num = 2;
		
		for(int i=0; i<N-1; i++) {
			if(arr[i] == 'L') {
				if(arr[i+1] == 'S') {
					num++;
				} else if(i>0 && arr[i-1] == 'L' && arr[i+1] == 'L') {
					num++;
					i++;
				}
			} else {
				num++;
			}
		}
		
		if(num > N) {
			num = N;
		}
		
		System.out.println(num);
		
		sc.close();
	}

}
