import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-20
 * Time: 오후 3:18
 */

public class sfc6
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[10001][101];
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        long[][] dp = new long[10001][101];
        for(int i=1; i<=M; i++)
        {
            for(int j=1; j<=N; j++)
                dp[i][j] = Long.max(dp[i-1][j], dp[i][j-1]) + ary[i][j];
        }

        System.out.println(dp[M][N]);
    }
}
