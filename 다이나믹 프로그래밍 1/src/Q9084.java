/*
동전

https://www.acmicpc.net/problem/9084
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 3:59
 */

public class Q9084
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());

            int[] ary = new int[20];
            int[] dp = new int[10001];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            dp[0] = 1;
            int M = Integer.parseInt(br.readLine());

            for(int money=0; money<=M; money++)
            {
                for(int id=0; id<N; id++)
                {
                    int cur = money - ary[id];

                    if(cur < 0)
                        break;

                    dp[money] += dp[cur];
                }
            }
            for(int i=0; i<=M; i++)
                System.out.print(dp[i] + " ");
            System.out.println();

            sb.append(dp[M]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
