package boj_1931_회의실배정;

import java.io.*;
import java.util.*;

public class Main {
	static int N, max;
	static int[] start, end;
	static boolean[] visited;

	static class Meeting implements Comparable<Meeting> {
		int start;
		int end;

		public Meeting(int start, int end) {
			this.start = start;
			this.end = end;
		}

		@Override
		public int compareTo(Meeting o) {
			if (this.end == o.end) {
				return this.start - o.start; // 끝나는 시간이 같을 경우 시작 시간에 대해 오름차순으로 정렬
			}
			return this.end - o.end; // 끝나는 시간에 대해 오름차순으로 정렬
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());

		List<Meeting> list = new ArrayList<Meeting>();

		for (int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());

			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());

			list.add(new Meeting(start, end));
		}

		Collections.sort(list);

		int end = 0; // 현재까지 갱신된 끝나는 시간
		int ans = 0; // 회의 개수

		// 정렬된 리스트 탐색
		for (Meeting meeting : list) {
			if (meeting.start >= end) { // 새로운 미팅의 시작시간이 현재까지 갱신된 가장 마지막 회의의 끝나는 시간보다 크거나 같으면
				end = meeting.end; // 끝나는 시간 갱신
				ans++; // 회의 개수 추가
			}
		}

		System.out.println(ans);
	}
}
