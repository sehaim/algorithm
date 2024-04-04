package swea_1289_원재의메모리복구;

import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;
		while(x <= T) {
			String str = sc.next();
			int[] memory = new int[str.length()];
			for(int i=0; i<str.length(); i++) {
				memory[i] = str.charAt(i) - '0';
			}
			
			int ans = 0;
			if(memory[0] == 1) {
				ans++;
			}
			int idx=0;
			while(idx < memory.length-1) {
				if(memory[idx] != memory[idx+1]) {
					ans++;
				}
				idx++;
			}
			System.out.println("#" + x + " " + ans);
			x++;
		}
		sc.close();
	}
}