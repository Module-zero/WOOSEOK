/*
Four Squares

https://www.acmicpc.net/problem/17626
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-06
 * Time: 오전 12:16
 */

public class Q17626
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[50001];
        for(int i=1; i<=50000; i++)
            dp[i] = 99999;

        for(int i=1; i*i<=n; i++)
        {
            for(int j=i*i; j<=n; j++)
                dp[j] = Integer.min(dp[j-i*i] + 1, dp[j]);
        }

        System.out.println(dp[n]);
    }
}
