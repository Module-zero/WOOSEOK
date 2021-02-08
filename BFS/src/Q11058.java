/*
크리보드

https://www.acmicpc.net/problem/11058
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-08
 * Time: 오후 2:34
 */

public class Q11058
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        dp[4] = 4;
        dp[5] = 5;
        dp[6] = 6;
        for(int i=7; i<=N; i++)
            dp[i] = Long.max(Long.max(dp[i-3] * 2, dp[i-4] * 3), dp[i-5] * 4);

        System.out.println(dp[N]);
    }
}
