package boj_5525_IOIOI;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int M = Integer.parseInt(br.readLine());

		String S = br.readLine();

		int ans = 0; // P가 S에 포함된 개수
		int patternNum = 0; // 연속된 "IOI" 패턴 개수

		for (int i = 1; i < M - 1; i++) {
			// 연속된 "IOI" 패턴 개수 찾기
			if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
				patternNum++;
				i++; // "IOI" 패턴을 찾으면 인덱스를 2만큼 이동해야하므로 1 증가

				// 연속된 패턴 개수가 N과 일치하면 정답 개수 1 증가
				// 연속된 패턴 개수는 1 감소
				if (patternNum == N) {
					patternNum--;
					ans++;
				}
			} else { // "IOI" 패턴이 없으면 patternNum 초기화 후 다음 인덱스 탐색
				patternNum = 0;
			}
		}

		System.out.println(ans);
	}
}