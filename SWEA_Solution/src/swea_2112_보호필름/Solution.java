package swea_2112_보호필름;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	static int D, W, K, min;
	static int[][] arr;
	static int[][] sel;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int t = 1;
		
		String[] str;
		
		while (t <= T) {
			str = br.readLine().split(" ");
			D = Integer.parseInt(str[0]);
			W = Integer.parseInt(str[1]);
			K = Integer.parseInt(str[2]);

			arr = new int[D][W];
			
			for (int r = 0; r < D; r++) {
				str = br.readLine().split(" ");
				for(int c=0; c<W; c++)
					arr[r][c] = Integer.parseInt(str[c]);
			}

			

			System.out.println("#" + t + " " + min);
			t++;
		}

	}
}
