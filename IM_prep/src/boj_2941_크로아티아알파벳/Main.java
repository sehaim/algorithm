package boj_2941_크로아티아알파벳;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		String str = sc.next();
		char[] charArr = str.toCharArray();
		int cnt = 0;
		
		for(int i=0; i<charArr.length; i++) {
			if(charArr[i] == '=' || charArr[i] == '-') {
				continue;
			} else if(charArr[i] == 'z' && i>0 && charArr[i-1] == 'd' && i<charArr.length-1 && charArr[i+1] == '=') {
				continue;
			} else if(charArr[i] == 'j' && i>0 && (charArr[i-1] == 'l' || charArr[i-1] == 'n')) {
				continue;
			}
			cnt++;
		}
		System.out.println(cnt);
		sc.close();
	}
}
