/*
돌 게임 4

https://www.acmicpc.net/problem/9658
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-11
 * Time: 오후 7:48
 */

public class Q9658
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 2;
        for(int i=5; i<=N; i++)
        {
            if(dp[i-1] == 1 || dp[i-3] == 1 || dp[i-4] == 1)
                dp[i] = 2;
            else
                dp[i] = 1;
        }

        System.out.println((dp[N] == 2) ? "SK" : "CY");
    }
}
