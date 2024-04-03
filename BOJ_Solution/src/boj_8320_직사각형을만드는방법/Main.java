package boj_8320_직사각형을만드는방법;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int ans=0;
		for(int i=1; i<=n; i++) {
			int cnt = 0;
			for(int j=1; j<=i; j++) {
				if(i%j == 0) {
					cnt++;
				}
			}
			if(cnt%2 == 1) {
				cnt = cnt/2+1;
			} else {
				cnt = cnt/2;
			}
			ans += cnt;
		}

		System.out.println(ans);
		sc.close();
	}
}
