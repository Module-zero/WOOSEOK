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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] token = new int[21];
            for(int i=0; i<N; i++)
                token[i] = Integer.parseInt(st.nextToken());

            int[] dp = new int[10001];
            int target = Integer.parseInt(br.readLine());
            for(int i=0; i<N; i++)
            {
                dp[token[i]]++;

                for(int j=token[i]; j<=target; j++)
                    dp[j] = dp[j] + dp[j - token[i]];
            }

            sb.append(dp[target]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
