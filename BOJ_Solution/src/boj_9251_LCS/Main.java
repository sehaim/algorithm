package boj_9251_LCS;

import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] dp;
    static int max;
    static String str1, str2;
    
    public static void main(String[] args) throws IOException {
        str1 = br.readLine();
        str2 = br.readLine();
        
        dp = new int[str2.length()+1];
        
        for(int i = 0; i < str1.length(); i++){
            dp(str1.charAt(i), 0, 0);
        }

        Arrays.sort(dp);
        System.out.print(dp[str2.length()]);
    }
/*
    static int lcs(String str1, String str2) {

        for (int i = 0; i < str1.length(); i++) {
            int comm = 0;
            for (int j = 0; j < str2.length(); j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    if (comm < dp[j]) max = Math.max(max, comm = dp[j]);
                    else max = Math.max(max, dp[j] = comm + 1);
                } else max = Math.max(max, comm = Math.max(comm, dp[j]));
            }
        }
        return max;
    }
*/
    static int dp(char character, int lcs, int idx){
        if(idx == str2.length()) return 0; // str2를 전부 탐색하면 return

        if(character == str2.charAt(idx) && lcs < dp[idx]) lcs = dp[idx]; // str1의 i번째 글자와 str2의 idx번째 글자가 같고, lcs가 dp[idx]보다 작으면 lcs = dp[idx]
        else if(character == str2.charAt(idx))dp[idx] = lcs + 1;
        else lcs = Math.max(lcs, dp[idx]);

        return dp(character, lcs , idx+1);
    }
}

