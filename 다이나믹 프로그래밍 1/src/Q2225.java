/*
합분해

문제
0부터 N까지의 정수 K개를 더해서 그 합이 N이 되는 경우의 수를 구하는 프로그램을 작성하시오.

덧셈의 순서가 바뀐 경우는 다른 경우로 센다(1+2와 2+1은 서로 다른 경우). 또한 한 개의 수를 여러 번 쓸 수도 있다.

입력
첫째 줄에 두 정수 N(1 ≤ N ≤ 200), K(1 ≤ K ≤ 200)가 주어진다.

출력
첫째 줄에 답을 1,000,000,000으로 나눈 나머지를 출력한다.
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

        int[][] dp = new int[N+1][K+1];

        for(int i=0; i<=N; i++)
            dp[i][1] = 1;
        for(int i=1; i<=K; i++)
            dp[0][i] = 1;

        for(int i=1; i<=N; i++)
        {
            for(int j=2; j<=K; j++)
            {
                for(int k=0; k<=N; k++)
                {
                    dp[i][j] = (dp[i][j] + dp[k][j-1]) % 1000000000;
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}
