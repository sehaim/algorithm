package SWEA_1230_암호문3;

import java.util.Scanner;

class Node {
	int pw;
	Node link;
	
	Node() {}
	
	Node(int pw) {
		this.pw = pw;
		this.link = null;
	}
}

class SinglyLinkedList {
	Node head;
	int size;
	
	SinglyLinkedList() {
		head = new Node();
	}
	
	public void addFirst(int pw) {
		Node newNode = new Node(pw);
		newNode.link = head.link;
		head.link = newNode;
		size++;
	}
	
	public void add(int pw) {
		Node newNode = new Node(pw);
		Node curr = head;
		while (curr.link != null) {
			curr = curr.link;
		}
		curr.link = newNode;
		size++;
	}
	
	void insert(int idx, int pw) {
		
		Node curr = head;
		for (int i=0; i<idx; i++) {
			curr = curr.link;
		}
		
		Node newNode = new Node(pw);
		
		newNode.link = curr.link;
		curr.link = newNode;
		size++;
	}
	
	public void delete(int idx) {
		Node curr = head;
		for (int i=0; i<idx; i++) {
			curr = curr.link;
		}

		curr.link = curr.link.link;
		size--;
	}
	
	public void printList() {
		Node curr = head.link;
		int num = 0;
		while (num < 10) {
			System.out.print(curr.pw + " ");
			curr = curr.link;
			num++;
		}
		System.out.println();
	}
	
}
public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while (tc <= 10) {
			SinglyLinkedList password = new SinglyLinkedList();
			int pw_num = sc.nextInt();
			
			password.addFirst(sc.nextInt());
			for(int i=1; i<pw_num; i++) {
				password.add(sc.nextInt());
			}
			
			int cm_num = sc.nextInt();
			int cm = 1;
			while (cm <= cm_num) {
				String command = sc.next();
				if (command.equals("I")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					while (y > 0) {
						int s = sc.nextInt();
						password.insert(x, s);
						x++;
						y--;
					}
				} else if (command.equals("D")) {
					int x = sc.nextInt();
					int y = sc.nextInt();
					while (y > 0) {
						password.delete(x);
						y--;
					}
				} else if (command.equals("A")) {
					int y = sc.nextInt();
					while (y > 0) {
						int s = sc.nextInt();
						password.add(s);
						y--;
					}
				}
				cm++;
			}
			System.out.print("#" + tc + " ");
			password.printList();
			tc++;
		}
		sc.close();
	}
}
