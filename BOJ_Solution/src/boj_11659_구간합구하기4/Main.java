package boj_11659_구간합구하기4;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] str = br.readLine().split(" ");

		int N = Integer.parseInt(str[0]);
		int M = Integer.parseInt(str[1]);

		str = br.readLine().split(" ");

		int[] arr = new int[N];

		arr[0] = Integer.parseInt(str[0]);

		// 입력 받은 숫자의 누적합으로 배열 저장
		for (int i = 1; i < N; i++) {
			arr[i] = arr[i - 1] + Integer.parseInt(str[i]);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < M; i++) {
			str = br.readLine().split(" ");

			int st = Integer.parseInt(str[0]);
			int ed = Integer.parseInt(str[1]);

			int sum = 0;

			// 시작 지점이 1이면 해당 배열의 값이 누적 합이므로, 바로 출력
			if (st == 1) {
				sum = arr[ed - 1];
			} else { // 그 외의 경우 구간의 합 = (해당 배열의 값) - (시작 지점 - 1 배열의 값)
				sum = arr[ed - 1] - arr[st - 2];
			}

			bw.write(sum + "\n");
		}

		bw.flush();

	}
}
