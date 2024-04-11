package swea_2382_미생물격리;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
	static int N, M, K;
	static int[][] arr, location;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int x = 1;

		while (x <= T) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();

			arr = new int[K][4];
			location = new int[N][N];

			for (int r = 0; r < K; r++) {
				for (int c = 0; c < 4; c++) {
					arr[r][c] = sc.nextInt();
				}
			}

			int ans = 0;

			for (int i = 0; i < M; i++) {
				for (int j = 0; j < K; j++) {
					arr[j][0] += dr[arr[j][3] - 1];
					arr[j][1] += dc[arr[j][3] - 1];

					location[arr[j][0]][arr[j][1]]++;

					if (arr[j][0] == 0) {
						arr[j][3] = 2;
						arr[j][2] /= 2;
					}
					if (arr[j][0] == N - 1) {
						arr[j][3] = 1;
						arr[j][2] /= 2;
					}
					if (arr[j][1] == 0) {
						arr[j][3] = 4;
						arr[j][2] /= 2;
					}
					if (arr[j][1] == N - 1) {
						arr[j][3] = 3;
						arr[j][2] /= 2;
					}
				}
				
				searchDirection();
			}

			for (int r = 0; r < K; r++) {
				ans += arr[r][2];
			}

			System.out.println("#" + x + " " + ans);
			x++;
		}
		sc.close();
	}

	public static void searchDirection() {
		List<int[]> idxList = new ArrayList<>();

		for (int r = 0; r < N; r++) {
			for (int c = 0; c < N; c++) {
				if (location[r][c] > 1) {
					int[] tmp = {r, c, location[r][c]};
					idxList.add(tmp);
				}
			}
		}
		
		int idx = 0;
		for(int i=0; i<idxList.size(); i++) {
			int[] tmp = idxList.get(i);
			int[][] tmpArr = new int[tmp[2]][2];
			for(int j=0; j<K; j++) {
				if(arr[j][0] == tmp[0] && arr[j][1] == tmp[1]) {
					tmpArr[idx][0] = j;
					tmpArr[idx][1] = arr[j][2];
				}
			}
			int max = -1;
			int maxIdx = -1;
			int sum = 0;
			for(int j=0; j<tmp[2]; j++) {
				sum += tmpArr[j][1];
				max = Math.max(max, tmpArr[j][1]);
				if(max == tmpArr[j][1]) maxIdx = j;
			}
			
			for(int j=0; j<tmp[2]; j++) {
				if(j != maxIdx) {
					arr[tmpArr[j][0]][2] = 0;
				} else {
					arr[tmpArr[j][0]][2] = sum;
				}
			}
			
		}
	}
}
