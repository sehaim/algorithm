package boj_1940_주몽;

import java.io.*;
import java.util.Arrays;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int N = Integer.parseInt(br.readLine());
    int M = Integer.parseInt(br.readLine());

    int[] arr = new int[N];
    String[] str_arr = br.readLine().split(" ");

    for (int i = 0; i < N; i++) {
      arr[i] = Integer.parseInt(str_arr[i]);
    }

    Arrays.sort(arr);

    int sum = 0;
    int left = 0;
    int right = N - 1;

    while (left < right) {
      if (arr[left] + arr[right] == M) { // 합이 M이면 갑옷의 개수 증가 후 포인터 두개 모두 안쪽으로 이동
        sum++;
        left++;
        right--;
      } else if (arr[left] + arr[right] < M) { // 합이 M보다 작으면 왼쪽 포인터 한칸 이동
        left++;
      } else { // 합이 M보다 크면 오른쪽 포인터 한칸 이동
        right--;
      }
    }

    System.out.println(sum);
  }
}
