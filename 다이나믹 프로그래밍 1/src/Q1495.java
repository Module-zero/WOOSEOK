/*
기타리스트

https://www.acmicpc.net/problem/1495
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 12:36
 */

public class Q1495
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[101][1001];
        int[] ary = new int[101];

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        dp[0][S] = true;
        for(int i=1; i<=N; i++)
        {
            boolean ok = false;
            for(int j=0; j<=M; j++)
            {
                if(dp[i-1][j])
                {
                    int sum = j + ary[i];
                    if(sum >= 0 && sum <= M)
                    {
                        dp[i][sum] = true;
                        ok = true;
                    }

                    sum = j - ary[i];
                    if(sum >= 0 && sum <= M)
                    {
                        dp[i][sum] = true;
                        ok = true;
                    }
                }
            }

            if(!ok)
            {
                System.out.println(-1);
                return;
            }
        }

        for(int i=1000; i>=0; i--)
        {
            if(dp[N][i])
            {
                System.out.println(i);
                return;
            }
        }
    }
}
