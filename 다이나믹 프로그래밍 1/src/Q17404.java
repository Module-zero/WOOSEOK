/*
RGB거리 2

https://www.acmicpc.net/problem/17404
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오후 3:49
 */

public class Q17404
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] house = new int[N+1][3];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int color=0; color<3; color++)
                house[i][color] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<3; i++)
        {
            int[][] dp = new int[N+1][3];

            // 1번 집의 색깔 고정
            dp[2][i] = Integer.MAX_VALUE;
            dp[2][(i+1)%3] = house[1][i] + house[2][(i+1)%3];
            dp[2][(i+2)%3] = house[1][i] + house[2][(i+2)%3];

            for (int j=3; j<=N; j++)
            {
                dp[j][0] = Integer.min(dp[j-1][1], dp[j-1][2]) + house[j][0];
                dp[j][1] = Integer.min(dp[j-1][0], dp[j-1][2]) + house[j][1];
                dp[j][2] = Integer.min(dp[j-1][0], dp[j-1][1]) + house[j][2];
            }

            // 1번 집의 색깔과 같은 N번 집은 선택할 수 없게 설정
            int ans = Integer.min(dp[N][(i+1)%3], dp[N][(i+2)%3]);

            if(min > ans)
                min = ans;
        }

        System.out.println(min);
    }
}
