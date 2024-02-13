package boj_17413_단어뒤집기;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();
		char[] strArr = str.toCharArray();
		
		for(int i=0; i<strArr.length; i++) {
			if(strArr[i] == '<') {
				while (strArr[i] != '>') {
					i++;
				}
			} else if(strArr[i] == ' ') {
				continue;
			} else {
				int len = 0;
				int idx = i;
				while (true) {
					if (idx >= strArr.length || strArr[idx] == ' ' || strArr[idx] == '<') {
						break;
					}
					len++;
					idx++;
				}

				char[] newArr = new char[len];
				idx = i;
				for(int j=0; j<len; j++) {
					newArr[j] = strArr[idx++];
				}

				idx = i;
				for(int j=len-1; j>=0; j--) {
					strArr[idx++] = newArr[j];
				}
				i = i + len - 1;
			}
		}
		
		for(int i=0; i<strArr.length; i++) {
			System.out.print(strArr[i]);
		}
		sc.close();
	}

}
