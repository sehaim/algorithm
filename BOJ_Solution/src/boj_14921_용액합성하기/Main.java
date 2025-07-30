package boj_14921_용액합성하기;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine());
		int[] solution = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			solution[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(solution);

		int lft = 0;
		int rgt = N - 1;
		int ans = Integer.MAX_VALUE;

		while (lft < rgt) {
			int value = solution[lft] + solution[rgt];

			// 특성값의 절댓값이 ans에 저장된 값의 절댓값보다 작을 경우 갱신
			if (Math.abs(ans) > Math.abs(value)) {
				ans = value;
			}

			// 특성값이 0이면 더이상 탐색 불필요
			if (value == 0)
				break;

			if (value > 0) { // 특성값이 양수일 경우 오른쪽 포인터 왼쪽으로 이동
				rgt--;
			} else { // 특성값이 음수일 경우 왼쪽 포인터 오른쪽으로 이동
				lft++;
			}
		}

		System.out.println(ans);
	}
}
