/*
계단 오르기

https://www.acmicpc.net/problem/2579
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오전 1:15
 */

public class Q2579
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[301];
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        int[] dp = new int[301];
        dp[1] = ary[1];
        dp[2] = dp[1] + ary[2];
        for(int i=3; i<=N; i++)
            dp[i] = Integer.max(dp[i-3] + ary[i-1] + ary[i], dp[i-2] + ary[i]);

        System.out.println(dp[N]);
    }
}
