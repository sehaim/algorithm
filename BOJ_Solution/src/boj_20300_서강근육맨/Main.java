package boj_20300_서강근육맨;

import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());

    long[] arr = new long[N];
    String[] str_arr = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      arr[i] = Long.parseLong(str_arr[i]);
    }

    Arrays.sort(arr);

    int left = 0;
    int right = N % 2 == 0 ? N - 1 : N - 2; // 운동기구의 개수가 홀수이면 무조건 근손실이 가장 큰 운동기구를 단독으로 사용
    long M = N % 2 == 0 ? arr[left] + arr[right] : arr[N - 1]; // 하루 근손실 합의 최댓값의 최솟값

    // 포인터로 최댓값 갱신
    while (left < right) {
      M = Math.max(M, arr[left] + arr[right]);
      left++;
      right--;
    }

    System.out.println(M);
  }
}
