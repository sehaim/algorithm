package swea_1224_계산기3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
	static int top = -1;
	static char[] stack = new char[] {};
	static int[] stack2 = new int[] {};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while (tc <= 10) {
			
			Map <Character, Integer> priority = new HashMap<>();
			priority.put('+', 1);
			priority.put('*', 2);
			priority.put('(', 0);
			
			int len = sc.nextInt();
			stack = new char [len];
			
			String expression = sc.next();
			String postfix = "";
			
			for (int i=0; i<expression.length(); i++) {
				char c = expression.charAt(i);
				if(c == '(') {
					push(c);
				} else if (c == ')') {
					while (stack[top] !='(') {
						postfix += pop();
					}
					pop();
				} else if ('0' <= c && c <= '9') {
					postfix += c;
				} else {
					if (isEmpty()) {
						push(c);
					} else {
						while (!isEmpty() && priority.get(c) <= priority.get(stack[top])) {
							postfix += pop();
						}
						push(c);
					}
				}
			}
			
			stack2 = new int [postfix.length()];
			
			for (int i=0; i<postfix.length(); i++) {
				char c = postfix.charAt(i);
				if('0' <= c && c<= '9') {
					pushInt(c - '0');
				} else if (c == '+') {
					int num1 = popInt();
					int num2 = popInt();
					pushInt(num1+num2);
				} else if (c == '*') {
					int num1 = popInt();
					int num2 = popInt();
					pushInt(num1*num2);
				}
			}
			
			int ans = popInt();

			System.out.println("#" + tc + " " + ans);
			tc++;
		}
		sc.close();
	}
	
	public static boolean isEmpty() {
		return top == -1;
	}
	
	public static boolean isFull() {
		return top == stack.length-1;
	}
	
	public static boolean isFullInt() {
		return top == stack2.length-1;
	}
	
	public static void push(char data) {
		if (isFull()) {
			System.out.println("더 이상 추가할 수 없습니다.");
		} else {
			stack[++top] = data;
		}
	}
	
	public static void pushInt(int data) {
		if (isFullInt()) {
			System.out.println("더 이상 추가할 수 없습니다.");
		} else {
			stack2[++top] = data;
		}
	}
	
	public static char pop() {
		if (isEmpty()) {
			System.out.println("더 이상 데이터가 없습니다.");
			return 'x';
		} else {
			char num = stack[top];
			stack[top] = 0;
			top--;
			return num;
		}
	}
	
	public static int popInt() {
		if (isEmpty()) {
			System.out.println("더 이상 데이터가 없습니다.");
			return Integer.MIN_VALUE;
		} else {
			int num = stack2[top];
			stack2[top] = 0;
			top--;
			return num;
		}
	}
}
