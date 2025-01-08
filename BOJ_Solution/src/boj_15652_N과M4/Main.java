package boj_15652_N과M4;

import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int[] sel;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		sel = new int[M];

		sb = new StringBuilder();

		Permutation(1, 0);

		System.out.println(sb);
	}

	public static void Permutation(int idx, int s_idx) {
		if (s_idx >= M) {
			for (int i = 0; i < M; i++) {
				sb.append(sel[i] + " ");
			}
			sb.append("\n");
			return;
		}

		for (int i = idx; i <= N; i++) {
			sel[s_idx] = i;
			Permutation(i, s_idx + 1);
		}
	}
}
