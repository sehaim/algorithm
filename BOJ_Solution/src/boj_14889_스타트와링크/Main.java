package boj_14889_스타트와링크;

import java.util.Scanner;

public class Main {
	public static int[][] arr;
	public static int N;
	public static int[] peopleArr;
	public static int peopleIdx;
	public static int linkTeam;
	public static int startTeam;
	public static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		peopleArr = new int[N/2];
		
		for(int r=0; r<N; r++) {
			for(int c=0; c<N; c++) {
				arr[r][c] = sc.nextInt();
			}
		}

		pickPerson(0, 0);
		
		System.out.println(min);
		sc.close();
	}
	
	public static void pickPerson(int idx, int j) {
		if(idx >= N/2) {
			searchMin();
			return;
		}
		for(int i=j; i<N/2+idx+1; i++) {
			peopleArr[idx] = i;
			pickPerson(idx+1, j+1);
			j++;
		}
		return;
	}
	
	public static void searchMin() {
		int[] peopleArr2 = new int[N/2];
		int idx2 = 0;
		
		label : for(int i=0; i<N; i++) {
			for(int j=0; j<N/2; j++) {
				if(peopleArr[j] == i) {
					continue label;
				}
			}
			peopleArr2[idx2++] = i;
		}
		
		linkTeam = 0;
		startTeam = 0;
		for(int i=0; i<peopleArr.length-1; i++) {
			for(int j=i; j<peopleArr.length; j++) {
				linkTeam += arr[peopleArr[i]][peopleArr[j]] + arr[peopleArr[j]][peopleArr[i]];
				startTeam += arr[peopleArr2[i]][peopleArr2[j]] + arr[peopleArr2[j]][peopleArr2[i]];
			}
		}
		
		int diff = Math.abs(linkTeam - startTeam);
		min = Math.min(min, diff);
	}
}
