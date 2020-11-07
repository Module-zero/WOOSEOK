/*
합분해

https://www.acmicpc.net/problem/2225
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-14
 * Time: 오전 12:10
 */

public class Q2225
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[201];
        int[] dp2 = new int[201];

        // k가 1이면 n에 관계없이 1(1개로 n을 만드는 방법)
        dp[1] = 1;
        dp2[1] = 1;

        for(int n=0; n<=N; n++)
        {
            for(int k=2; k<=K; k++)
            {
                dp[k] = (dp[k-1] + dp2[k]) % 1000000000;

                // 이전 항을 저장
                dp2[k] = dp[k];
            }
        }

        System.out.println(dp2[K]);
    }
}
