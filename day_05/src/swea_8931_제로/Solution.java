package swea_8931_제로;

import java.util.Scanner;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int t = 1;
		Stack<Integer> stack = new Stack<>();
		while (t <= TC) {
			int K = sc.nextInt();
			int cnt = 0;
			while (cnt < K) {
				int k = sc.nextInt();
				if(k != 0) {
					stack.add(k);
				} else {
					stack.pop();
				}
				cnt++;
			}
			
			int ans = 0;
			while(!stack.isEmpty()) {
				ans += stack.pop();
			}
			
			System.out.println("#" + t + " " + ans);
			t++;
		}
		sc.close();
	}
}
