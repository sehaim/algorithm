package boj_17386_선분교차1;

import java.io.*;
import java.util.*;

// CCW 이용 풀이
public class Main2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 선분1을 이루는 두 점
		int x1 = Integer.parseInt(st.nextToken());
		int y1 = Integer.parseInt(st.nextToken());
		int x2 = Integer.parseInt(st.nextToken());
		int y2 = Integer.parseInt(st.nextToken());

		st = new StringTokenizer(br.readLine());
		
		// 선분2를 이루는 두 점
		int x3 = Integer.parseInt(st.nextToken());
		int y3 = Integer.parseInt(st.nextToken());
		int x4 = Integer.parseInt(st.nextToken());
		int y4 = Integer.parseInt(st.nextToken());

		int ans = 0;
		
		// 선분1에서 점 (x3, y3), (x4, y4) 로의 방향
		int ccw1 = ccw(x1, y1, x2, y2, x3, y3);
		int ccw2 = ccw(x1, y1, x2, y2, x4, y4);
		// 선분2에서 점 (x1, y1), (x2, y2) 로의 방향
		int ccw3 = ccw(x3, y3, x4, y4, x1, y1);
		int ccw4 = ccw(x3, y3, x4, y4, x2, y2);
		
		// 선분1에서 나머지 두 점이 서로 반대 방향에 위치하고, 선분2에서 나머지 두 점이 서로 반대 방향에 위치한다면 두 선분은 교차한다.  
		if (ccw1 * ccw2 < 0 && ccw3 * ccw4 < 0)
			ans = 1;

		System.out.println(ans);

	}

	public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
		return (x2 - x1) * (y3 - y2) - (y2 - y1) * (x3 - x2) < 0 ? -1 : 1;
	}
}
