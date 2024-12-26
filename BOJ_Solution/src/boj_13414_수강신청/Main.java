package boj_13414_수강신청;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int K = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());

		HashMap<String, Integer> hashMap = new HashMap<String, Integer>();

		for (int i = 0; i < L; i++) {
			hashMap.put(br.readLine(), i);
		}

		StringBuilder sb = new StringBuilder();

		List<String> keySet = new ArrayList<>(hashMap.keySet());

		// Value 값으로 오름차순 정렬
		keySet.sort(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return hashMap.get(o1).compareTo(hashMap.get(o2));
			}
		});

		int cnt = 0;

		for (String key : keySet) {
			sb.append(key + "\n");
			cnt++;

			if (cnt == K) {
				break;
			}
		}

		System.out.print(sb);
	}
}
