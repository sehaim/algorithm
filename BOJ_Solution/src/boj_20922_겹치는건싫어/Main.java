package boj_20922_겹치는건싫어;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] arr = new int[N];
		int[] num = new int[100001]; // 수의 종류 저장

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}

		int length = 1; // 수열의 길이

		int lft = 0;
		int rgt = 0;

		num[arr[lft]]++; // 왼쪽 포인터가 가리키는 수의 개수 1 증가

		// 오른쪽 포인터가 N - 1 보다 작을 동안
		while (rgt < N - 1) {
			// 오른쪽 포인터 이동하면서 해당하는 수의 개수 1 증가
			// 증가한 수가 K를 넘으면 while문 실행
			if (++num[arr[++rgt]] > K) {
				// 왼쪽 포인터 이동하면서 이동하기 전 원래 가리키던 수의 개수 1 감소
				// 감소했을 때 K가 되면 while문 종료
				while (--num[arr[lft++]] != K) {
				}
			}

			// 길이 최댓값 비교 갱신
			length = Math.max(length, rgt - lft + 1);
		}

		System.out.println(length);
	}
}
