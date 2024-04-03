package boj_2309_일곱난쟁이;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		
		for(int i=0; i<arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		
		int allSum = 0;
		for(int i=0; i<arr.length; i++) {
			allSum += arr[i];
		}
		
		int twoSum = 0;
		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				twoSum = arr[i] + arr[j];
				if(allSum-twoSum == 100) {
					arr[i] = 0;
					arr[j] = 0;
					break;
				}
			}
			if(allSum-twoSum == 100) {
				break;
			}
		}
		
		int[] newArr = new int[7];
		int cnt = 0;	
		for(int i=0; i<arr.length; i++) {
			if(arr[i] != 0) {
				newArr[cnt++] = arr[i];
			}
		}
		
		for(int i=0; i<newArr.length-1; i++) {
			int minIdx = i;
			for(int j=i; j<newArr.length; j++) {
				if(newArr[minIdx]>newArr[j]) {
					minIdx = j;
				}
			}
			int tmp = newArr[i];
			newArr[i] = newArr[minIdx];
			newArr[minIdx] = tmp;
		}
		
		for(int i=0; i<newArr.length; i++) {
			System.out.println(newArr[i]);
		}
		sc.close();
	}
}
