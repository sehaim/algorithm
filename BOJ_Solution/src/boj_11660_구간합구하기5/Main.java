package boj_11660_구간합구하기5;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N + 1][N + 1]; // edge case 처리를 위해 N+1 크기로 선언

        for (int r = 1; r <= N; r++) {
            st = new StringTokenizer(br.readLine());

            for (int c = 1; c <= N; c++) {
                int num = Integer.parseInt(st.nextToken());

                // (1, 1)부터 (r, c)까지의 누적 합 계산
                arr[r][c] = num + arr[r][c - 1] + arr[r - 1][c] - arr[r - 1][c - 1];
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            // 시작 지점
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            // 끝나는 지점
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 구간 합 계산
            int sum = arr[x2][y2] - (arr[x1 - 1][y2] + arr[x2][y1 - 1] - arr[x1 - 1][y1 - 1]);

            bw.write(sum + "\n");
        }

        bw.flush();
    }
}