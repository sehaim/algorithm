package boj_1181_단어정렬;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String[] arr = new String[N];

		for (int i = 0; i < N; i++) {
			arr[i] = sc.next();
		}

		Arrays.sort(arr);
		Arrays.sort(arr, Comparator.comparing(String::length));

		for (int i = 0; i < arr.length; i++) {
			if (i < arr.length - 1) {
				if (arr[i].equals(arr[i + 1])) {
					continue;
				} else {
					System.out.println(arr[i]);
				}
			} else {
				System.out.println(arr[i]);
			}
		}
		sc.close();
	}
}
