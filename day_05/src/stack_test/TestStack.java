package stack_test;

public class TestStack {
	public int[] stack = new int[] {};
	public int top = -1;
	
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
