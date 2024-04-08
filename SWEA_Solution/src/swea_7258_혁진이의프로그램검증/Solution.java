package swea_7258_혁진이의프로그램검증;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Solution {
	static int R, C, memory, dir;
	static String ans;
	static char[][] charArr;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int t = 1;

		while (t <= T) {
			String[] arr = br.readLine().split(" ");
			R = Integer.parseInt(arr[0]);
			C = Integer.parseInt(arr[1]);
			memory = 0;
			charArr = new char[R][C];
			visited = new boolean[R][C];

			for (int r = 0; r < R; r++) {
				String str = br.readLine();
				charArr[r] = str.toCharArray();
			}

			ans = "YES";
			dir = 3;
			dfs(0, 0, 0);

			System.out.println("#" + t + " " + ans);
			t++;
		}
	}

	public static void dfs(int r_idx, int c_idx, int cnt) {
		if(cnt > 4*R*C) {
			ans = "NO";
			return;
		}
		
		if(memory < 0) {
			memory = memory%15;
			memory += 16;
		} else if (memory > 16) {
			memory = memory%15;
			memory -= 1;
		}
		if (r_idx == R) {
			r_idx = 0;
		} else if (r_idx == -1) {
			r_idx = R - 1;
		}
		if (c_idx == C) {
			c_idx = 0;
		} else if (c_idx == -1) {
			c_idx = C - 1;
		}
		
		visited[r_idx][c_idx] = true;

		switch (charArr[r_idx][c_idx]) {
		case '<':
			dir = 2;
			break;
		case '>':
			dir = 3;
			break;
		case '^':
			dir = 0;
			break;
		case 'v':
			dir = 1;
			break;
		case '_':
			if (memory == 0)
				dir = 3;
			else
				dir = 2;
			break;
		case '|':
			if (memory == 0)
				dir = 1;
			else
				dir = 0;
			break;
		case '?':
			dfs(r_idx + dr[0], c_idx + dc[0], cnt+1);
			dfs(r_idx + dr[1], c_idx + dc[1], cnt+1);
			dfs(r_idx + dr[2], c_idx + dc[2], cnt+1);
			dfs(r_idx + dr[3], c_idx + dc[3], cnt+1);
			return;
		case '.':
			break;
		case '@':
			return;
		case '+':
			memory += 1;
			break;
		case '-':
			memory -= 1;
			break;
		default:
			memory = charArr[r_idx][c_idx] - '0';
		}

		System.out.println(r_idx +" "+c_idx);
		
		dfs(r_idx + dr[dir], c_idx + dc[dir], cnt+1);
	}
}
