package Queue;

public class Queue {
	static int[] queue = new int[] {};
	static int front = -1;
	static int rear = -1;
	
	public static void main(String[] args) {
		createQueue(10);
		for (int i=0; i<queue.length; i++) {
			enQueue(i);
		}
		System.out.println(isFull());
		
		for (int i=0; i<queue.length; i++) {
			int item = deQueue();
			System.out.println(item);
		}
		System.out.println(isEmpty());
		
	}
	
	public static void createQueue(int size) {
		queue = new int[size];
	}
	
	public static void enQueue(int data) {
		if (isFull()) {
			System.out.println("�����͸� ������ �� �����ϴ�.");
			return;
		}
		queue[++rear] = data;
	}
	
	public static int deQueue() {
		if(isEmpty()) {
			System.out.println("�� �̻� ����� �����Ͱ� �����ϴ�.");
			return -1;
		}
		return queue[++front];
	}
	
	public static int Qpeek() {
		if(isEmpty()) {
			System.out.println("�� �̻� ����� �����Ͱ� �����ϴ�.");
			return -1;
		}
		return queue[front + 1];
	}
	
	public static boolean isFull() {
		return rear == queue.length - 1;
	}
	
	public static boolean isEmpty() {
		return front == rear;
	}
	
}