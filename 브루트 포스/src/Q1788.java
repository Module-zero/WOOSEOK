/*
피보나치 수의 확장

https://www.acmicpc.net/problem/1788
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-11
 * Time: 오후 7:38
 */

public class Q1788
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] dp = new long[1000001];

        int absN = Math.abs(n);
        dp[0] = 0;
        dp[1] = 1;
        for(int i=2; i<=absN; i++)
            dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;

        StringBuffer sb = new StringBuffer();
        if(n > 0)
        {
            sb.append(1).append('\n');
            sb.append(dp[n]).append('\n');
        }
        else if(n == 0)
        {
            sb.append(0).append('\n');
            sb.append(dp[n]).append('\n');
        }
        else
        {
            if(absN % 2 == 0)
                sb.append(-1).append('\n');
            else
                sb.append(1).append('\n');

            sb.append(dp[absN]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
