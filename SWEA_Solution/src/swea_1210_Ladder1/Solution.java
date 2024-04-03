package swea_1210_Ladder1;

import java.util.Scanner;
 
class Solution
{
    public static void main(String args[]) throws Exception {
 
        //System.setIn(new FileInputStream("input.txt"));
        Scanner sc = new Scanner(System.in);
        int T;
        int[] dr = new int[] {0, 0};
        int[] dc = new int[] {-1, 1};
 
        for(int test_case = 1; test_case <= 10; test_case++) {
            T = sc.nextInt();
            int[][] arr = new int[100][100];
            for(int r=0; r<100; r++) {
                for(int c=0; c<100; c++) {
                    arr[r][c] = sc.nextInt();
                }
            }
             
            int rs = 99;
            int cs = 0;
            for(int c=0; c<100; c++) {
                if (arr[rs][c] == 2) {
                    cs = c;
                }
            }
            rs = 98;
            arr[rs][cs] = 2;
             
            while(rs>0) {
                for(int c=0; c<100; c++) {
                    if(arr[rs][c] == 2) {
                        cs = c;
                        for(int d=0; d<2; d++) {
                            int nr = rs + dr[d];
                            int nc = c + dc[d];
                            if(nr>=0 && nr<100 && nc>=0 && nc<100) {
                                arr[nr][nc] += 10;
                            }
                        }
                    }
                    for(int i=0; i<100; i++) {
                        if(arr[rs][i] == 11) {
                            cs = i;
                            arr[rs][cs] = 2;
                            if((cs-1)>=0 && (cs-1)<100) {
                                if(arr[rs][cs-1] == 2) {
                                    arr[rs][cs-1] = 0;
                                }
                            }
                            c = 0;
                        }
                    }
                }
                rs--;
                arr[rs][cs] = 2;
                }

            System.out.println("#" + T + " " + cs);
        }
        sc.close();
    }
}