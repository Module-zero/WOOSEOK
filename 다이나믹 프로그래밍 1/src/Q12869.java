/*
뮤탈리스크

https://www.acmicpc.net/problem/12869
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-14
 * Time: 오후 10:15
 */

public class Q12869
{
    static int[][][] dp = new int[61][61][61];

    public static int foo(int a, int b, int c)
    {
        if(a < 0)
            return foo(0, b, c);
        if(b < 0)
            return foo(a, 0, c);
        if(c < 0)
            return foo(a, b, 0);

        if(a == 0 && b == 0 && c == 0)
            return 0;

        if(dp[a][b][c] != -1)
            return dp[a][b][c];

        dp[a][b][c] = 10000000;
        int ret;
        ret = foo(a-9, b-3, c-1);
        if(dp[a][b][c] > ret)
            dp[a][b][c] = ret;
        ret = foo(a-9, b-1, c-3);
        if(dp[a][b][c] > ret)
            dp[a][b][c] = ret;
        ret = foo(a-3, b-9, c-1);
        if(dp[a][b][c] > ret)
            dp[a][b][c] = ret;
        ret = foo(a-1, b-9, c-3);
        if(dp[a][b][c] > ret)
            dp[a][b][c] = ret;
        ret = foo(a-1, b-3, c-9);
        if(dp[a][b][c] > ret)
            dp[a][b][c] = ret;
        ret = foo(a-3, b-1, c-9);
        if(dp[a][b][c] > ret)
            dp[a][b][c] = ret;

        return ++dp[a][b][c];
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<=60; i++)
        {
            for (int j = 0; j <= 60; j++)
            {
                for (int k = 0; k <= 60; k++)
                    dp[i][j][k] = -1;
            }
        }

        int[] SCV = {0, 0, 0};

        for(int i=0; i<N; i++)
            SCV[i] = Integer.parseInt(st.nextToken());

        System.out.println(foo(SCV[0], SCV[1], SCV[2]));
    }
}
