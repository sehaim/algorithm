package stack_test;

public class Test {
	public static void main(String[] args) {
		TestStack stack1 = new TestStack();
		stack1.stack = new int [10];
		
		stack1.push(1);
		stack1.push(2);
		stack1.push(3);
		stack1.push(4);
		stack1.push(5);
		stack1.push(6);
		stack1.push(7);
		stack1.push(8);
		stack1.push(9);
		stack1.push(10);
		stack1.push(11);
		
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		System.out.println(stack1.pop());
		
	}
}
	