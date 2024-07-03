package boj_17219_비밀번호찾기;

import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] numStr = br.readLine().split(" ");

		int N = Integer.parseInt(numStr[0]);
		int M = Integer.parseInt(numStr[1]);

		Map<String, String> map = new HashMap<String, String>();

		for (int i = 0; i < N; i++) {
			String[] pwArr = br.readLine().split(" ");
			map.put(pwArr[0], pwArr[1]);
		}

		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < M; i++) {
			bw.write(map.get(br.readLine()) + "\n");
		}

		bw.flush();
	}
}
