/*
거스름돈

https://www.acmicpc.net/problem/14916
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-08
 * Time: 오후 2:21
 */

public class Q14916
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        for(int i=1; i<=n; i++)
            dp[i] = 100000;

        int[] ary = {2, 5};
        for(int token : ary)
        {
            for(int i=token; i<=n; i++)
                dp[i] = Integer.min(dp[i-token] + 1, dp[i]);
        }

        System.out.println((dp[n] == 100000) ? -1 : dp[n]);
    }
}
