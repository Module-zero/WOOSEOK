/*
괄호

https://www.acmicpc.net/problem/10422
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-11
 * Time: 오후 5:48
 */

public class Q10422
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        long[] dp = new long[5001];
        dp[0] = 1;

        for(int i=2; i<=5000; i+=2)
        {
            for(int j=2; j<=i; j+=2)
                dp[i] = (dp[i] + ((dp[j-2] * dp[i-j]) % 1000000007)) % 1000000007;
        }

        while(T-- > 0)
        {
            int L = Integer.parseInt(br.readLine());

            sb.append(dp[L]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
