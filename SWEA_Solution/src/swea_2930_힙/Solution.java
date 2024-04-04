package swea_2930_힙;

import java.util.Scanner;

public class Solution {
	public static int[] heap;
	public static int heapSize;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int tc = 1;
		while(tc <= T) {
			heap = new int[100001];
			heapSize = 0;
			System.out.print("#" + tc);
			int N = sc.nextInt();
			int n = 1;
			
			while(n <= N) {
				int op = sc.nextInt();
				if(op == 1) {
					int x = sc.nextInt();
					add(x);
				} else if(op == 2) {
					System.out.print(" " + pop());
				}
				n++;
			}
			
			System.out.println();
			tc++;
		}
		sc.close();
	}
	
	public static void add(int x) {
		heap[++heapSize] = x;
		
		int ch = heapSize;
		int p = heapSize/2;
		
		while(p > 0 && heap[p] < heap[ch]) {
			int tmp = heap[ch];
			heap[ch] = heap[p];
			heap[p] = tmp;
			
			ch = p;
			p = ch/2;
		}
	}
	
	public static int pop() {
		if(heapSize == 0) {
			return -1;
		}
		int popItem = heap[1];
		heap[1] = heap[heapSize];
		heap[heapSize--] = 0;
		
		int p = 1;
		int ch = p*2;
		
		if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
			ch++;
		}
		while(ch <= heapSize && heap[p] < heap[ch]) {	
			int tmp = heap[ch];
			heap[ch] = heap[p];
			heap[p] = tmp;
			
			p = ch;
			ch = p*2;
			if(ch+1 <= heapSize && heap[ch] < heap[ch+1]) {
				ch++;
			}
		}
		
		return popItem;
	}
}
