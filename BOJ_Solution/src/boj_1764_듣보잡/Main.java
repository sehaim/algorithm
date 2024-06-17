package boj_1764_듣보잡;

import java.io.*;
import java.util.*;

//public class lexicographicOrder implements Comparator<String> {
//	@Override
//	public int compare(String o1, String o2) {
//		if()
//	}
//}

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		
		for(int i=0; i<N; i++) {
			map.put(i, br.readLine());
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<Integer, String> newMap = new TreeMap<Integer, String>();
		List<String> list = new ArrayList<String>();
		
		list.sort(String);
		
		int num = 0;
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(map.containsValue(str)) {
				newMap.put(num++, str);
			}
		}
		
		bw.write(newMap.size() + "\n");
		
		for(int i=0; i<newMap.size(); i++) {
			bw.write(newMap.get(i) + "\n");
		}
		
		bw.flush();
	}
}
