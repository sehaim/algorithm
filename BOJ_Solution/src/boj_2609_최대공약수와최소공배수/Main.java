package boj_2609_최대공약수와최소공배수;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());

		int gcd = GCD(a, b);

		System.out.println(gcd);
		System.out.println(a * b / gcd);

	}

	// 최대 공약수
	public static int GCD(int a, int b) {
		int r = a % b;

		// 나머지가 0이면 b가 최대공약수
		if (r == 0)
			return b;
		// 나머지가 0이 아니면 a = b, b = r 재귀 호출
		return GCD(b, r);
	}
}
