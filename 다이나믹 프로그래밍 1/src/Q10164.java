/*
격자상의 경로

https://www.acmicpc.net/problem/10164
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 10:47
 */

public class Q10164
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ary = new int[15][15];
        int cnt = 1;

        int sr = N-1;
        int sc = M-1;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                ary[i][j] = cnt++;
                if(ary[i][j] == K)
                {
                    sr = i;
                    sc = j;
                }
            }
        }

        int[][] dp = new int[15][15];
        for(int i=0; i<=sr; i++)
        {
            for(int j=0; j<=sc; j++)
            {
                if(i == 0 && j == 0)
                    dp[i][j] = 1;
                else if(i == 0)
                    dp[i][j] = dp[i][j-1];
                else if(j == 0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        int sum = dp[sr][sc];
        for(int i=sr; i<N; i++)
        {
            for(int j=sc; j<M; j++)
            {
                if(i == sr && j == sc)
                    dp[i][j] = 1;
                else if(i == sr)
                    dp[i][j] = dp[i][j-1];
                else if(j == sc)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        System.out.println(sum * dp[N-1][M-1]);
    }
}
