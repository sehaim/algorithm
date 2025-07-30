package boj_2631_줄세우기;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int n = 0;

		int[] arr = new int[N];

		while (n++ < N) {
			arr[n] = Integer.parseInt(br.readLine());
		}
	}
}
