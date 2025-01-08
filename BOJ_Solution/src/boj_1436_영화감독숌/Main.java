package boj_1436_영화감독숌;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());
		int ans = 666;
		int cnt = 1;

		while (cnt < N) {
			ans++;

			if (Integer.toString(ans).contains("666")) {
				cnt++;
			}
		}

		System.out.println(ans);
	}
}
