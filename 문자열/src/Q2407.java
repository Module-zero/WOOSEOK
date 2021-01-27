/*
조합

https://www.acmicpc.net/problem/2407
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 11:43
 */

public class Q2407
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        String[][] dp = new String[101][51];
        int minM = Integer.min(m, n-m);
        dp[0][0] = "1";
        for(int i=1; i<=n; i++)
        {
            dp[i][0] = "1";

            for(int j=1; j <= i && j <= minM; j++)
            {
                String str1 = dp[i-1][j-1];
                String str2 = dp[i-1][j];
                if(str2 == null)
                {
                    dp[i][j] = str1;
                    continue;
                }

                int len1 = str1.length();
                int len2 = str2.length();
                int len = Integer.min(len1, len2);
                int diff = Math.abs(len1 - len2);
                StringBuffer sb = new StringBuffer();
                int next = 0;
                for(int l=len-1; l>=0; l--)
                {
                    int ch1 = str1.charAt(l) - '0';
                    if(len1 > len2)
                        ch1 = str1.charAt(l + diff) - '0';

                    int ch2 = str2.charAt(l) - '0';
                    if(len2 > len1)
                        ch2 = str2.charAt(l + diff) - '0';

                    int sum = ch1 + ch2 + next;
                    int rem = sum % 10;
                    sb.insert(0, rem);
                    next = sum / 10;
                }

                if(len1 != len2)
                {
                    String str = (len == len2) ? str1 : str2;
                    while(diff > 0)
                    {
                        diff--;
                        int ch = str.charAt(diff) - '0';
                        sb.insert(0, (ch + next) % 10);
                        next = (ch + next) / 10;
                    }
                }

                if(next != 0)
                    sb.insert(0, next);

                dp[i][j] = sb.toString();
            }
        }

        System.out.println(dp[n][minM]);
    }
}
