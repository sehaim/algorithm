package boj_8958_OX퀴즈;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while(t <= T) {
			String str = sc.next();
			char[] charArr = str.toCharArray();
			int score = 0;
			int cnt = 0;
			for(int i=0; i<charArr.length; i++) {
				if(charArr[i] == 'O') {
					cnt++;
					score +=cnt;
				} else if(charArr[i] == 'X') {
					cnt = 0;
				}
			}
			System.out.println(score);
			t++;
		}
		sc.close();
	}
}
