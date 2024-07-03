package boj_1764_듣보잡;

import java.io.*;
import java.util.*;

public class Main {	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] strArr = br.readLine().split(" ");
		
		int N = Integer.parseInt(strArr[0]);
		int M = Integer.parseInt(strArr[1]);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		for(int i=0; i<N; i++) {
			map.put(br.readLine(), 0);
		}
		
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Map<String, Integer> newMap = new TreeMap<String, Integer>();
		
		for(int i=0; i<M; i++) {
			String str = br.readLine();
			if(map.containsKey(str)) {
				newMap.put(str, 0);
			}
		}
		
		List<String> keySet = new ArrayList<String>(newMap.keySet());
		
		Collections.sort(keySet);
		
		bw.write(newMap.size() + "\n");
		
		for(String key : newMap.keySet()) {
			bw.write(key + "\n");
		}
		
		bw.flush();
	}
}
