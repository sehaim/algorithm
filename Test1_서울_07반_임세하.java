import java.util.Scanner;

public class Test1_서울_07반_임세하 {
	static int[][] arr;
	static int cnt;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			arr = new int[9][9];
			for (int r = 0; r < 9; r++) {
				for (int c = 0; c < 9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int N = sc.nextInt();
			int n = 1;
			cnt = 0;
			while (n <= N) {
				int M = sc.nextInt();
				int D = sc.nextInt();
				int S = sc.nextInt();

				label: for (int r = 0; r < 9; r++) {
					if (r % 2 == 0) {
						for (int c = 0; c < 9; c++) {
							if (location(r, c, M, D, S)) {
								break label;
							}
						}
					} else {
						for (int c = 8; c >= 0; c--) {
							if (location(r, c, M, D, S)) {
								break label;
							}
						}
					}
				}
				n++;
			}
			if (cnt == 0) {
				cnt = -1;
			}
			System.out.println("#" + t + " " + cnt);
			t++;
		}
		sc.close();
	}
	
	// 들어갈 위치를 찾는 함수 location
	public static boolean location(int r, int c, int M, int D, int S) {
		if (arr[r][c] == 0) {
			int noise = 0;
			int idx = 0; // 거리에 따른 참조 변수 idx
			for (int r2 = r - D; r2 <= r + D; r2++) {
				for (int c2 = c - idx; c2 <= c + idx; c2++) {
					if (r2 >= 0 && r2 < 9 && c2 >= 0 && c2 < 9 && arr[r2][c2] != -1) {
						noise += arr[r2][c2];
					}
				}
				if (r2 >= r) {
					idx--;
				} else {
					idx++;
				}
			}
			if (noise > M) {
				// 순회 후 noise 의 합이 M보다 크면 false 반환
				return false;
			} else {
				arr[r][c] = S;
				cnt++;
				// 그렇지 않으면 cnt 증가 후 true 반환
				return true;
			}
		}
		return false;
	}
}
