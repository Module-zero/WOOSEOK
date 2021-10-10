import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-10
 * Time: 오후 5:04
 */

public class Q17485
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][1002];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[1001][1002][3];
        for(int i=0; i<M; i++)
            for(int j=0; j<3; j++)
                dp[0][i][j] = ary[0][i];

        for(int i=1; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(j+1 < M)
                    dp[i][j][0] = Integer.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + ary[i][j];
                else
                    dp[i][j][0] = 1000000;

                dp[i][j][1] = Integer.min(dp[i-1][j][0], dp[i-1][j][2]) + ary[i][j];

                if(j-1 >= 0)
                    dp[i][j][2] = Integer.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + ary[i][j];
                else
                    dp[i][j][2] = 1000000;
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i<M; i++)
        {
            for (int j = 0; j < 3; j++)
                ans = Integer.min(ans, dp[N - 1][i][j]);
        }

        System.out.println(ans);
    }
}
