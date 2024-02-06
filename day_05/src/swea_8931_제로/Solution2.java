package swea_8931_제로;

import java.util.Scanner;

public class Solution2 {
	
	int top = -1;
	int[] stack = new int[] {};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		int t = 1;

		while (t <= TC) {
			int K = sc.nextInt();
			Solution2 sol = new Solution2();
			sol.stack = new int[K];
			int cnt = 0;
			while (cnt < K) {
				int k = sc.nextInt();
				if(k != 0) {
					sol.push(k);
				} else {
					sol.pop();
				}
				cnt++;
			}
			
			int ans = 0;
			while(!sol.isEmpty()) {
				ans += sol.pop();
			}
			
			System.out.println("#" + t + " " + ans);
			t++;
		}
		sc.close();
	}
	
	public boolean isEmpty() {
		return top == -1;
	}
	
	public boolean isFull() {
		return top == stack.length-1;
	}
	
	public void push(int data) {
		if (isFull()) {
			System.out.println("더 이상 추가할 수 없습니다.");
		} else {
			stack[++top] = data;
		}
	}
	
	public int pop() {
		if (isEmpty()) {
			System.out.println("더 이상 데이터가 없습니다.");
			return Integer.MIN_VALUE;
		} else {
			return stack[top--];
		}
	}
}
