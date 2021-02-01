/*
자두나무

https://www.acmicpc.net/problem/2240
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-01
 * Time: 오후 4:08
 */

public class Q2240
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] ary = new int[1001];
        for(int i=0; i<T; i++)
            ary[i] = Integer.parseInt(br.readLine());

        int[][] dp = new int[31][1001];

        for(int t=1; t<=T; t++)
        {
            int plum = ary[t-1];

            int lim = Integer.min(t, W);

            if(plum == 1)
                dp[0][t] = dp[0][t-1] + 1;
            else
                dp[0][t] = dp[0][t-1];

            for(int w=1; w<=lim; w++)
            {
                // 자두가 1번 나무에
                if(plum == 1)
                {
                    // 내 위치도 1번 나무
                    if(w % 2 == 0)
                        dp[w][t] = Integer.max(dp[w-1][t-1] + 1, dp[w][t-1] + 1);
                    // 내 위치는 2번 나무
                    else
                        dp[w][t] = Integer.max(dp[w-1][t-1], dp[w][t-1]);
                }
                // 자두가 2번 나무에
                else
                {
                    // 내 위치는 1번 나무
                    if(w % 2 == 0)
                        dp[w][t] = Integer.max(dp[w-1][t-1], dp[w][t-1]);
                    // 내 위치도 2번 나무
                    else
                        dp[w][t] = Integer.max(dp[w-1][t-1] + 1, dp[w][t-1] + 1);
                }
            }
        }

        int max = 0;
        for(int w=0; w<=W; w++)
            max = Integer.max(max, dp[w][T]);

        System.out.println(max);
    }
}
