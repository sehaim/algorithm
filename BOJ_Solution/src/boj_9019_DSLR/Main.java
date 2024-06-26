package boj_9019_DSLR;

import java.util.*;


public class Main {
	static class Change {
		int[] n;
		String op;

		public Change(int[] n, String op) {
			this.n = n;
			this.op = op;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 0;

		while (t < T) {
			int A = sc.nextInt();
			int B = sc.nextInt();

			boolean[] visited = new boolean[10000];

			Queue<Change> queue = new LinkedList<Change>();

			int[] n = numToArr(A);
			
			// 입력받은 숫자를 배열로 변경 후, 최초에는 빈 문자열과 함깨 Queue에 삽입 
			queue.add(new Change(n, ""));
			visited[concatNum(n)] = true;

			while (!queue.isEmpty()) {
				Change curr = queue.poll();

				n = curr.n;
				
				// Queue에서 꺼낸 숫자가 B와 같으면 명령어 출력 후 break 
				if (concatNum(n) == B) {
					System.out.println(curr.op);
					break;
				}
				
				// 각 명령어에 따른 연산을 배열로 선언 
				int[] newNum = { concatNum(n) * 2 % 10000, concatNum(n) == 0 ? 9999 : concatNum(n) - 1,
						concatNum(new int[] { n[1], n[2], n[3], n[0] }),
						concatNum(new int[] { n[3], n[0], n[1], n[2] }) };
				
				String[] dslr = {"D", "S", "L", "R"};
				
				// 명령어에 따른 연산을 순회하며 해당 숫자를 방문하지 않았으면, 연산된 숫자와 함께 명령어를 추가하여 Queue에 삽입 
				for(int i=0; i<4; i++) {
					if(!visited[newNum[i]]) {
						queue.add(new Change(numToArr(newNum[i]), curr.op + dslr[i]));
						visited[newNum[i]] = true;
					}
				}
			}
			t++;
		}
		sc.close();
	}
	
	// 길이가 4인 배열을 숫자로 바꾸는 method 
	public static int concatNum(int[] n) {
		return (((n[0] * 10 + n[1]) * 10) + n[2]) * 10 + n[3];
	}
	
	// 숫자를 길이가 4인 배열로 바꾸는 method 
	public static int[] numToArr(int num) {
		int[] n = new int[4];

		for (int i = 3; i >= 0; i--) {
			n[i] = num % 10;
			num /= 10;
		}
		
		return n;
	}
}
