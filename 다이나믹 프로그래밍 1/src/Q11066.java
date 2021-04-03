/*
파일 합치기

https://www.acmicpc.net/problem/11066
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-11
 * Time: 오후 3:24
 */

public class Q11066
{
    static int[] ary = new int[501];
    static int[][] dp;

    public static int foo(int i, int j)
    {
        if(i == j)
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];

        int sum = 0;
        for(int k=i; k<=j; k++)
            sum += ary[k];

        for(int k=i; k<=j-1; k++)
        {
            int tmp = foo(i, k) + foo(k+1, j) + sum;
            if(dp[i][j] == -1 || dp[i][j] > tmp)
                dp[i][j] = tmp;
        }

        return dp[i][j];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int K = Integer.parseInt(br.readLine());
            dp = new int[501][501];
            for(int i=0; i<501; i++)
            {
                for(int j=0; j<501; j++)
                    dp[i][j] = -1;
            }

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=K; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            sb.append(foo(1, K)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
