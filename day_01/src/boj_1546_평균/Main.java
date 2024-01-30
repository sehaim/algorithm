package boj_1546_평균;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int [N];
		for(int i=0; i<N; i++) {
			arr[i] = sc.nextInt();
		}
		
		int M = -12345;
		for(int i=0; i<N; i++) {
			if(arr[i]>M) {
				M = arr[i];
			}
		}
		
		int sum = 0;
		for(int i=0; i<N; i++) {
			sum += arr[i];
		}
		
		double avg = (double)sum/M*100/N;
		
		System.out.println(avg);
		
		sc.close();
	}

}
