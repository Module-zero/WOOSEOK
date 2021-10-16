import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-16
 * Time: 오후 3:16
 */

public class Q2157
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ary = new int[301][301];
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            if(a > b)
                continue;

            ary[a][b] = Integer.max(ary[a][b], c);
        }

        int[][] dp = new int[301][301];
        for(int i=2; i<=N; i++)
            dp[i][2] = ary[1][i];

        // 방문한 도시 수
        for(int i=3; i<=M; i++)
        {
            // 도착 도시
            for(int j=3; j<=N; j++)
            {
                // 시작 도시
                for(int k=2; k<j; k++)
                {
                    // 1에서 시작하지 않았으면 스킵
                    if(dp[k][i-1] == 0 || ary[k][j] == 0)
                        continue;

                    dp[j][i] = Integer.max(dp[j][i], dp[k][i-1] + ary[k][j]);
                }
            }
        }

        int ans = 0;
        for(int i=2; i<=M; i++)
            ans = Integer.max(ans, dp[N][i]);

        System.out.println(ans);
    }
}
