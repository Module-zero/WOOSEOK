import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-16
 * Time: 오후 5:28
 */

public class Qtest3
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] time = new int[101][101];
        int[][][] run = new int[101][101][101];
        for(int i=1; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=N; j++)
                time[i][j] = Integer.parseInt(st.nextToken());

            for(int j=1; j<=N; j++)
            {
                for(int k=1; k<=N; k++)
                {
                    if(j == k)
                        continue;

                    // 단계, 시작지점, 목적지
                    run[i][j][k] = Integer.parseInt(st.nextToken());
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            time[K][i] = Integer.parseInt(st.nextToken());

        int[][] dp = new int[101][101];
        for(int i=1; i<=N; i++)
            dp[1][i] = time[1][i];

        for(int i=2; i<=K; i++)
        {
            for(int j=1; j<=N; j++)
            {
                int ans = Integer.MAX_VALUE;
                for(int k=1; k<=N; k++)
                {
                    if(j == k)
                        continue;

                    ans = Integer.min(ans, dp[i-1][k] + run[i-1][k][j] + time[i][j]);
                }

                dp[i][j] = ans;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=1; i<=N; i++)
            ans = Integer.min(ans, dp[K][i]);

        System.out.println(ans);
    }
}
