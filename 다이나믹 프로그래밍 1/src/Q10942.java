/*
팰린드롬?

https://www.acmicpc.net/problem/10942
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-11
 * Time: 오후 2:15
 */

public class Q10942
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[2001];
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        boolean[][] dp = new boolean[2001][2001];

        for(int i=1; i<=N; i++)
            dp[i][i] = true;
        for(int i=1; i<=N-1; i++)
        {
            if(ary[i] == ary[i+1])
                dp[i][i+1] = true;
        }
        for(int k=3; k<=N; k++)
        {
            for(int i=1; i<=N-k+1; i++)
            {
                int j = i+k-1;

                if(ary[i] == ary[j] && dp[i+1][j-1])
                    dp[i][j] = true;
            }
        }

        int M = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            if(dp[S][E])
                sb.append("1\n");
            else
                sb.append("0\n");
        }

        System.out.print(sb.toString());
    }
}
