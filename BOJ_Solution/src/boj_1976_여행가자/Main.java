package boj_1976_여행가자;

import java.io.*;

public class Main {
	static int N, M;
	static int[][] graph;
	static int[] des;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		N = Integer.parseInt(br.readLine());
		M = Integer.parseInt(br.readLine());
		graph = new int[N][N];
		des = new int[M];

		for (int r = 0; r < N; r++) {
			String[] str = br.readLine().split(" ");
			for (int c = 0; c < N; c++) {
				graph[r][c] = Integer.parseInt(str[c]);
			}
		}

		String[] str = br.readLine().split(" ");
		for (int i = 0; i < M; i++) {
			des[i] = Integer.parseInt(str[i]);
		}
		
		String ans = "YES";
		
		
		
		System.out.println(ans);

//		for(int r=0; r<N; r++) {
//			for(int c=0; c<N; c++) {
//				System.out.print(graph[r][c] + " ");
//			}
//			System.out.println();
//		}

	}
}
