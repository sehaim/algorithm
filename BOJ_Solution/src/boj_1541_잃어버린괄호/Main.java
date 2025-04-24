package boj_1541_잃어버린괄호;

import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int ans = 0;

		String[] minusNum = br.readLine().split("-"); // '-'를 기준으로 식 분할

		for (int i = 0; i < minusNum.length; i++) {
			String[] plusNum = minusNum[i].split("\\+"); // 분할한 식을 '+'를 기준으로 다시 분할

			int sum = 0;

			// 덧셈
			for (String num : plusNum) {
				sum += Integer.parseInt(num);
			}

			// 0번째 인덱스 이후부터는 ans에서 뺄셈
			if (i != 0) {
				ans -= sum;
			} else {
				ans += sum;
			}
		}

		System.out.println(ans);
	}
}
