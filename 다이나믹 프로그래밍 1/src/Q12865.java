/*
평범한 배낭

https://www.acmicpc.net/problem/12865
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-11
 * Time: 오후 4:47
 */

public class Q12865
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] V = new int[101];
        int[] W = new int[101];

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            W[i] = Integer.parseInt(st.nextToken());
            V[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[101][100001];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=K; j++)
            {
                dp[i][j] = dp[i-1][j];
                if(j-W[i] >= 0)
                    dp[i][j] = Integer.max(dp[i][j], dp[i-1][j-W[i]] + V[i]);
            }
        }

        System.out.println(dp[N][K]);
    }
}
