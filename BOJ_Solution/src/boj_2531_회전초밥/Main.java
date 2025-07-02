package boj_2531_회전초밥;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		int[] dish = new int[N];
		int[] sushi = new int[D + 1];

		for (int i = 0; i < N; i++) {
			dish[i] = Integer.parseInt(br.readLine());
		}

		sushi[C] = 1; // 쿠폰으로 먹을 수 있는 초밥 C는 항상 종류에 포함된다.

		int kind = 1; // 초밥 C로 인한 가짓수
		int ans = 0;

		// 0부터 K번째 까지의 그릇 종류 및 개수 저장
		for (int i = 0; i < K; i++) {
			int num = dish[i];

			if (sushi[num] == 0) {
				kind++;
			}
			sushi[num]++;
		}

		int lft = 0; // 왼쪽 포인터
		int rgt = K - 1; // 오른쪽 포인터

		// 왼쪽 포인터가 0부터 N-1까지 움직이면 전부 순회한 것
		while (lft < N) {
			// 왼쪽 포인터가 오른쪽으로 한칸 이동하면서 원래 가리키던 접시의 개수가 0이 되면
			// 종류를 1 감소시킨다.
			if (--sushi[dish[lft++]] == 0) {
				kind--;
			}

			// 오른쪽 포인터가 오른쪽으로 한칸 이동하면서 새롭게 가리키는 접시의 개수가 원래 0이었으면
			// 종류를 1 증가시킨다.
			// 모듈러 연산은 오른쪽 포인터가 N을 넘어갔을 때, 다시 0부터 시작하기 위해 수행
			if (sushi[dish[++rgt % N]]++ == 0) {
				kind++;
			}

			// 먹을 수 있는 초밥 종류의 최댓값 비교 후 갱
			ans = Math.max(ans, kind);

		}

		System.out.println(ans);
	}
}
