/*
사과와 바나나

https://www.acmicpc.net/problem/3114
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-14
 * Time: 오후 5:05
 */

public class Q3114
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] A = new int[1501][1501];
        int[][] B = new int[1501][1501];

        for(int i=1; i<=R; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=C; j++)
            {
                String str = st.nextToken();
                int len = str.length();

                if(str.charAt(0) == 'A')
                    A[i][j] = Integer.parseInt(str.substring(1, len));
                else
                    B[i][j] = Integer.parseInt(str.substring(1, len));

                B[i][j] = B[i][j-1] + B[i][j];

                A[i][j] = A[i-1][j] + A[i][j];
            }
        }

        int[][] dp = new int[1501][1501];
        for(int i=1; i<=R; i++)
        {
            for(int j=1; j<=C; j++)
            {
                int right = dp[i][j-1] + A[R][j-1] - A[i][j-1];
                int down = dp[i-1][j] + B[i-1][C] - B[i-1][j];
                int rd = dp[i-1][j-1] + A[R][j-1] - A[i-1][j-1] + B[i-1][C] - B[i-1][j-1];

                if(i == 1)
                    dp[i][j] = right;
                else if(j == 1)
                    dp[i][j] = down;
                else
                    dp[i][j] = Integer.max(right, Integer.max(down, rd));
            }
        }

        System.out.println(dp[R][C]);
    }
}
