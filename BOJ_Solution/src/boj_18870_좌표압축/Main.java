package boj_18870_좌표압축;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int N = Integer.parseInt(br.readLine());

		int[] arr = new int[N];
		int[] sortedArr = new int[N];

		StringTokenizer st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			int num = Integer.parseInt(st.nextToken());

			arr[i] = num;
			sortedArr[i] = num;
		}

		// 배열 오름차순으로 정렬
		Arrays.sort(sortedArr);

		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		int rank = 0;

		for (int i = 0; i < N; i++) {
			// 중복 방지 (map에 key가 없을 경우)
			if (!map.containsKey(sortedArr[i])) {
				map.put(sortedArr[i], rank++); // 숫자와 순위 함께 저장
			}
		}

		// 배열을 순회하며 map에 저장된 해당 값의 순위 출력
		for (int i = 0; i < N; i++) {
			sb.append(map.get(arr[i]) + " ");
		}

		System.out.println(sb);
	}
}
