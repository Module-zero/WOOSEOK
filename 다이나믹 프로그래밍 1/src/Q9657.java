/*
돌 게임 3

https://www.acmicpc.net/problem/9657
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 10:06
 */

public class Q9657
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[1001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 1;
        dp[4] = 1;

        for(int i=5; i<=N; i++)
        {
            boolean isOk = false;
            if(dp[i-1] == 2 || dp[i-3] == 2 || dp[i-4] == 2)
                dp[i] = 1;
            else
                dp[i] = 2;
        }

        System.out.println(dp[N] == 1 ? "SK" : "CY");
    }
}
