package boj_3052_나머지;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[42];
		int num;
		
		for(int i=0; i<10; i++) {
			num = sc.nextInt();
			arr[num%42]++;
		}
		
		int cnt = 0;
		
		for(int i=0; i<42; i++) {
			if(arr[i] != 0) {
				cnt++;
			}
		}
		System.out.println(cnt);
		sc.close();
	}
}
