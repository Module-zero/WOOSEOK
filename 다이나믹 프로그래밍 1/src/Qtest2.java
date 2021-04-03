/*

 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-16
 * Time: 오후 5:10
 */

public class Qtest2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[1001];
        int[] B = new int[1001];
        int[] Arun = new int[1001];
        int[] Brun = new int[1001];
        for(int i=1; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            Arun[i] = Integer.parseInt(st.nextToken());
            Brun[i] = Integer.parseInt(st.nextToken());
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        A[N] = Integer.parseInt(st.nextToken());
        B[N] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[1001][2];
        dp[1][0] = A[1];
        dp[1][1] = B[1];

        for(int i=2; i<=N; i++)
        {
            dp[i][1] = dp[i-1][0] + Arun[i-1] + B[i];
            dp[i][0] = dp[i-1][1] + Brun[i-1] + A[i];
        }

        System.out.println(Integer.min(dp[N][0], dp[N][1]));
    }
}
