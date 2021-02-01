/*
신나는 함수 실행

https://www.acmicpc.net/problem/9184
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-01
 * Time: 오후 9:10
 */

public class Q9184
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int[][][] dp = new int[21][21][21];

        for(int a=0; a<=20; a++)
        {
            for(int b=0; b<=20; b++)
            {
                for(int c=0; c<=20; c++)
                {
                    if(a <= 0 || b <= 0 || c <= 0)
                        dp[a][b][c] = 1;
                    else if(a < b && b < c)
                        dp[a][b][c] = dp[a][b][c-1] + dp[a][b-1][c-1] - dp[a][b-1][c];
                    else
                        dp[a][b][c] = dp[a-1][b][c] + dp[a-1][b-1][c] + dp[a-1][b][c-1] - dp[a-1][b-1][c-1];
                }
            }
        }

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a == -1 && b == -1 && c == -1)
                break;

            sb.append("w(").append(a).append(", ").append(b).append(", ").append(c).append(") = ");
            if(a <= 0 || b <= 0 || c <= 0)
                sb.append(dp[0][0][0]).append('\n');
            else if(a > 20 || b > 20 || c > 20)
                sb.append(dp[20][20][20]).append('\n');
            else
                sb.append(dp[a][b][c]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
