package boj_9375_패션왕신해빈;

import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int T = Integer.parseInt(st.nextToken());
		int t = 0;

		while (t < T) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());

			Map<String, Integer> map = new HashMap<String, Integer>();

			for (int i = 0; i < n; i++) {
				st = new StringTokenizer(br.readLine());
				st.nextToken(); // 옷의 이름은 필요 없음 
				String dep = st.nextToken();
				
				// 같은 옷의 종류가 존재하지 않으면 map에 추가 
				if (!map.containsKey(dep)) {
					map.put(dep, 1);
				} else { // 같은 옷의 종류가 존재하면 기존 값에서 1 증가 
					int m = map.get(dep);
					map.replace(dep, ++m);
				}
			}
			// 1로 초기화 
			int ans = 1;
			
			// map 순회하며 value+1을 ans에 곱해준다 
			for (String key : map.keySet()) {
				ans *= map.get(key) + 1;
			}
			
			// 옷을 전부 입지 않는 경우는 뺀다 
			System.out.println(ans - 1);

			t++;
		}
	}
}