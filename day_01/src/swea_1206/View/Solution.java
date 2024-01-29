package swea_1206.View;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int tc=1; tc<11; tc++) {
			int N = sc.nextInt();
			int[] arr = new int [N];
			int[] arr2 = new int [4];
			int sum = 0;
			
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			for(int i=2; i<N-2; i++) {
				int min = 500;
				if(arr[i]>arr[i-1] && arr[i]>arr[i-2] && arr[i]>arr[i+1] && arr[i]>arr[i+2]) {
					arr2[0] = arr[i]-arr[i-1];
					arr2[1] = arr[i]-arr[i-2];
					arr2[2] = arr[i]-arr[i+1];
					arr2[3] = arr[i]-arr[i+2];
					for(int j=0; j<4; j++) {
						if(arr2[j] < min) {
							min = arr2[j];
						}
					}
					sum += min;
				}
			}
			System.out.println("#" + tc + " " + sum);
		}
		sc.close();
	}
}
