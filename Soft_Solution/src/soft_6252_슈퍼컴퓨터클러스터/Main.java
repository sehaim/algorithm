package soft_6252_슈퍼컴퓨터클러스터;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		long B = Long.parseLong(st.nextToken());

		int[] computers = new int[N];

		st = new StringTokenizer(br.readLine());

		for (int i = 0; i < N; i++) {
			computers[i] = Integer.parseInt(st.nextToken());
		}

		Arrays.sort(computers); // 성능에 대해 오름차순으로 정렬

		long start = computers[0];
		long end = (long) Math.sqrt(B) + computers[0]; // 성능의 최댓값
		long ans = start;

		// 이분탐색
		while (start <= end) {
			long mid = (start + end) / 2;

			long sum = 0;

			for (int i = 0; i < N; i++) {
				if (computers[i] >= mid)
					break; // 성능이 mid 보다 작은 경우에만 연산 수행

				long diff = mid - computers[i];
				sum += diff * diff; // 필요한 비용 더하기

				// 비용이 B보다 커지면 바로 end 값 바꾼 후, for문 종료
				if (sum > B) {
					end = mid - 1;
					break;
				}
			}

			// 합이 B보다 작으면 ans에 mid 저장 후 start 이동
			if (sum < B) {
				ans = mid;
				start = mid + 1;
			} else if (sum == B) { // 합이 B와 같으면 ans에 mid 저장 후, while문 종료
				ans = mid;
				break;
			}
		}

		System.out.println(ans);
	}
}
