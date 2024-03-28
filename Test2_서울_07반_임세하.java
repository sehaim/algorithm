import java.util.Arrays;
import java.util.Scanner;

public class Test2_서울_07반_임세하 {
	static int[] sel;
	static int[][] arr;
	static int max;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int t = 1;
		while (t <= T) {
			arr = new int[3][9];
			sel = new int[9];

			for (int r = 0; r < 3; r++) {
				for (int c = 0; c < 9; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			max = Integer.MIN_VALUE;
			combination(0, 0, 0);

			System.out.println("#" + t + " " + max);
			t++;
		}
		sc.close();
	}

	public static void combination(int idx, int s_idx, int r_idx) {
		if (s_idx >= 3) {
			combination(0, 0, r_idx + 1);
			if (r_idx >= 3) {
				max = Math.max(max, calSum());
			}
			return;
		}

		for (int c = idx; c <= 6 + s_idx; c++) {
			if (sel[c] == 0) {
				sel[c] = r_idx;
				combination(c + 1, s_idx + 1, r_idx);
				sel[c] = 0;
			}
		}

	}

	public static int calSum() {
		int sum = 0;
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 9; c++) {
				if (sel[c] == r) {
					sum += arr[r][c];
				}
			}
		}
		return sum;
	}
}
