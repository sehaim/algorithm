package boj_7579_앱;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int[] memories = new int[N];
    int[] costs = new int[N];

    String[] tmp_1 = br.readLine().split(" ");
    String[] tmp_2 = br.readLine().split(" ");

    int maxCost = 0; // 발생할 수 있는 최대 비용

    for (int i = 0; i < N; i++) {
      memories[i] = Integer.parseInt(tmp_1[i]);
      costs[i] = Integer.parseInt(tmp_2[i]);

      maxCost += costs[i];
    }

    int[][] dp = new int[N + 1][maxCost + 1]; // dp[i][j] : i번째의 앱을 종료하고, j의 비용을 썼을 때 확보 가능한 최대 메모리

    for (int i = 1; i <= N; i++) {
      for (int j = 0; j <= maxCost; j++) {
        if (j >= costs[i - 1]) {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - costs[i - 1]] + memories[i - 1]);
        } else {
          dp[i][j] = dp[i - 1][j];
        }
      }
    }

    int ans = Integer.MAX_VALUE;

    // dp 배열을 전부 순회하며 확보 가능한 최대 메모리가 M 이상일 때의 비용 j의 최솟값을 찾는다.
    for (int i = 0; i <= N; i++) {
      for (int j = 0; j <= maxCost; j++) {
        if (dp[i][j] >= M) {
          ans = Math.min(j, ans);
        }
      }
    }

    System.out.println(ans);
  }
}
