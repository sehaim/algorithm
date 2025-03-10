
public class MinHeap {
	static int[] heap = new int[100];
	static int heapSize;

	public static void main(String[] args) {
		heapPush(1);
		heapPush(38);
		heapPush(7);
		heapPush(5);
		heapPush(90);
		heapPush(62);

		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());
		System.out.println(heapPop());

		/* 결과
		   1
		   5
		   7
		   38
		   62
		   90
		 */
	}
	
	// swap
	static void swap(int a, int b) {
		int tmp = heap[a];
		heap[a] = heap[b];
		heap[b] = tmp;
	}
	
	// 삽입 
	static void heapPush(int data) {
		// 마지막 노드에 삽입
		heap[++heapSize] = data;

		int ch = heapSize;
		int p = ch / 2;
		
		// 자식이 더 작으면 swap
		while (p > 0 && heap[p] > heap[ch]) {
			swap(p, ch);

			ch = p;
			p = ch / 2;
		}
	}
	
	// 삭제 
	static int heapPop() {
		// 루트에 있는 값 삭제
		int popItem = heap[1];
		
		// 마지막에 있는 원소 루트로 옮기기
		heap[1] = heap[heapSize--];

		int p = 1;
		int ch = p * 2;

		while (ch <= heapSize && heap[p] > heap[ch]) {
			// 오른쪽 자식이 존재하고, 오른쪽 자식의 값이 왼쪽 자식의 값보다 작을 경우 오른쪽 자식으로 이동
			if (ch + 1 <= heapSize && heap[ch + 1] < heap[ch]) {
				ch = ch + 1;
			}
			// 자식이 더 작으면 swap
			swap(p, ch);

			p = ch;
			ch = p * 2;
		}

		return popItem;
	}
}
