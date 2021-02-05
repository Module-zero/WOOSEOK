/*
이항 계수 1

https://www.acmicpc.net/problem/11050
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오후 5:45
 */

public class Q11050
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        k = Integer.min(k, n-k);
        int[][] dp = new int[11][11];
        dp[0][0] = 1;

        for(int i=1; i<=n; i++)
        {
            dp[i][0] = 1;
            for(int j=1; j<=k; j++)
                dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
        }

        System.out.println(dp[n][k]);
    }
}
