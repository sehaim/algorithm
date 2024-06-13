package boj_11723_집합;

import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> S;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int M = Integer.parseInt(br.readLine());
		S = new ArrayList<Integer>();

		operation: for (int i = 0; i < M; i++) {
			String[] str = br.readLine().split(" ");
			int num = -1;
			if(str.length == 2) {
				num = Integer.parseInt(str[1]);				
			}
			
			if (str[0].equals("add")) {
				for (int j = 0; j < S.size(); j++) {
					if (S.get(j) == num) {
						continue operation;
					}
				}
				S.add(num);
				
			} else if (str[0].equals("remove")) {
				
				for (int j = 0; j < S.size(); j++) {
					if (S.get(j) == num) {
						S.remove(j);
						continue operation;
					}
				}
				
			} else if (str[0].equals("check")) {
				for (int j = 0; j < S.size(); j++) {
					if (S.get(j) == num) {
						bw.write("1\n");
						continue operation;
					}
				}
				bw.write("0\n");
				continue operation;
				
			} else if (str[0].equals("toggle")) {
				
				for (int j = 0; j < S.size(); j++) {
					if (S.get(j) == num) {
						S.remove(j);
						continue operation;
					}
				}
				S.add(num);
				
			} else if (str[0].equals("all")) {
				
				S = new ArrayList<Integer>(
						Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20));
				
			} else if (str[0].equals("empty")) {
				
				S = new ArrayList<Integer>();
				
			}
		}
		bw.flush();
	}
}
