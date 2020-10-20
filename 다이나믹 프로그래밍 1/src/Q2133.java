/*
타일 채우기

https://www.acmicpc.net/problem/2133
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오후 3:23
 */

public class Q2133
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        dp[0] = 1;

        if(N % 2 == 0)
        {
            for (int i=2; i<=N; i+=2)
            {
                dp[i] = 3*dp[i-2];

                for(int j=i-4; j>=0; j-=2)
                    dp[i] += 2*dp[j];
            }
        }

        System.out.println(dp[N]);
    }
}
