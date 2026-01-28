package boj_1459_걷기;

import java.io.*;
import java.util.*;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int x = Integer.parseInt(st.nextToken());
    int y = Integer.parseInt(st.nextToken());
    long w = Long.parseLong(st.nextToken());
    long s = Long.parseLong(st.nextToken());

    long answer = 0;

    // 정사각형 1개를 걸어서 가는 것이 가로지르는 것 보다 빠를 때 -> 걷기로만 이동
    if (2 * w < s) {
      answer = (long) (x + y) * w;
    }
    // 정사각형 1개를 가로지르는 것이 정사각형 "한 변"을 걷는 것보다 빠를 때 -> 가로질러서만 이동 + 마지막에 도달하지 못하면 걷기
    else if (w > s) {
      answer = Math.abs(x - y) % 2 == 0 ? Math.max(x, y) * s : (long) (Math.max(x, y) - 1) * s + w; // x, y의 차가 홀수이면 가로지르기만으로 도달할 수 없다.
    }
    // 나머지 경우 (가로지르기 + 걷기)
    else {
      answer = (long) Math.abs(x - y) * w + Math.min(x, y) * s;
    }

    System.out.println(answer);
  }
}