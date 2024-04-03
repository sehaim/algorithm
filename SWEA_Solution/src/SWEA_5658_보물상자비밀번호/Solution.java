package SWEA_5658_보물상자비밀번호;

import java.util.Arrays;
import java.util.Scanner;
 
public class Solution {
    static char[] numArr;
    static String[] strArr;
    static int[] newNumArr;
    static char[][] combArr;
    static int num, N, K;
 
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int t = 1;
 
        while (t <= T) {
            N = sc.nextInt();
            K = sc.nextInt();
            num = N / 4;
            String str = sc.next();
            numArr = str.toCharArray();
            combArr = new char[4][num];
            newNumArr = new int[N];
             
            int nIdx = 0;
             
            for(int i=0; i<num; i++) {
                combinationNum(i);
                 
                for(int c=0; c<4; c++) {
                    newNumArr[nIdx] = changeNum(combArr[c]);
                    nIdx++;
                }
            }
             
            for(int i=0; i<N-1; i++) {
                for(int j=i+1; j<N; j++) {
                    if(newNumArr[i] == newNumArr[j]) {
                        newNumArr[i] = 0;
                    }
                     
                }
            }
             
            Arrays.sort(newNumArr);
            System.out.println("#" + t + " " + newNumArr[N-K]);
            t++;
        }
        sc.close();
    }
 
    public static void combinationNum(int idx) {
        for (int i = 0; i < 4; i++) {
            int c_idx = 0;
            for (int j = idx + i * num; j < idx + (i + 1) * num; j++) {
                if(j >= N) {
                    combArr[i][c_idx] = numArr[j-N];
                } else {
                    combArr[i][c_idx] = numArr[j];
                }
                c_idx++;
            }
        }
    }
 
    public static int changeNum(char[] arr) {
        int sum = 0;
        for(int j=0; j<num; j++) {
            if(arr[j] >= '0' && arr[j] <= '9') {
                sum += (arr[j]-'0')*Math.pow(16, num-1-j);
            } else {
                switch(arr[j]) {
                case 'A': sum += 10*Math.pow(16, num-1-j); break;
                case 'B': sum += 11*Math.pow(16, num-1-j); break;
                case 'C': sum += 12*Math.pow(16, num-1-j); break;
                case 'D': sum += 13*Math.pow(16, num-1-j); break;
                case 'E': sum += 14*Math.pow(16, num-1-j); break;
                case 'F': sum += 15*Math.pow(16, num-1-j); break;
                }
            }
        }
        return sum;
    }
}