/*
1, 2, 3 더하기 4

https://www.acmicpc.net/problem/15989
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-14
 * Time: 오후 9:40
 */

public class Q15989
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[] dp = new int[10001];
        dp[0] = 1;
        for(int i=1; i<=3; i++)
        {
            for(int j=1; j<=10000; j++)
            {
                if(j - i >= 0)
                    dp[j] += dp[j-i];
            }
        }

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());

            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
