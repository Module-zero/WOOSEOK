/*
떡 먹는 호랑이

https://www.acmicpc.net/problem/2502
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-01
 * Time: 오후 9:36
 */

public class Q2502
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int D = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[31];
        dp[0] = 1;
        dp[1] = 1;
        for(int i=2; i<=30; i++)
            dp[i] = dp[i-1] + dp[i-2];

        int first = dp[D-3];
        int second = dp[D-2];

        for(int a=1; first * a <= K; a++)
        {
            int b = K - (first * a);

            if(b % second == 0)
            {
                b /= second;
                System.out.println(a);
                System.out.println(b);
                return;
            }
        }
    }
}
