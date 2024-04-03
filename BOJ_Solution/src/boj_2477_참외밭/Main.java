package boj_2477_참외밭;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		int[] cnt = new int[6];
		int[] arr = new int[6];
		
		for(int i=0; i<6; i++) {
			cnt[i] = sc.nextInt();
			arr[i] = sc.nextInt();
		}
		
		int max12 = Integer.MIN_VALUE;
		int max34 = Integer.MIN_VALUE;
		
		for(int i=0; i<6; i++) {
			if(cnt[i] == 1 || cnt[i] == 2) {
				if(arr[i] > max12) {
					max12 = arr[i];
				}
			} else if(cnt[i] == 3 || cnt[i] == 4) {
				if(arr[i] > max34) {
					max34 = arr[i];
				}
			}
		}
		
		int[] cnt2 = new int[5];
		for(int i=0; i<6; i++) {
			cnt2[cnt[i]]++;
		}
		
		for(int i=0; i<6; i++) {
			if(cnt2[cnt[i]] != 2) {
				arr[i] = 0;
			}
		}
		
		int idx = 0;
		for(int i=0; i<6; i++) {
			if(arr[i] == 0) {
				idx = i;
				break;
			}
		}
		
		int[] arr2 = new int[6];
		for(int i=0; i<6; i++) {
			if(idx+i >= 6) {
				arr2[i] = arr[idx+i-6];
			} else if(idx+i < 6) {
				arr2[i] = arr[idx+i];
			}
		}
		
		int square2 = 0;
		if(arr2[5] == 0) {
			square2 = arr2[2]*arr2[3];
		} else {
			square2 = arr2[3]*arr2[4];
		}
		int square = max12 * max34;
		int ans = num*(square-square2);

		System.out.println(ans);
		sc.close();
	}
}
