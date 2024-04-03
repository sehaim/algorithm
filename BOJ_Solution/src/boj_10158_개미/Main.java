package boj_10158_개미;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int t = Integer.parseInt(br.readLine());
		
		x = (x + t)%(2*w);
		if(x > w) {
			x = w - (x-w);
		}
		
		y = (y + t)%(2*h);
		if(y > h) {
			y = h - (y-h);
		}
		
		StringBuilder sb = new StringBuilder();
		sb.append(x).append(' ').append(y);
		
		bw.write(sb.toString());
		bw.close();
	}
}
