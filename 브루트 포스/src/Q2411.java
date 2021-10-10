import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-10
 * Time: 오후 5:23
 */

public class Q2411
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=0; i<A; i++)
        {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ary[r][c] = 1;
        }

        for(int i=0; i<B; i++)
        {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ary[r][c] = 2;
        }

        int[][][] dp = new int[101][101][A+1];

        dp[1][1][0] = 1;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(ary[i][j] == 2)
                    continue;

                int cnt = ary[i][j];
                for(int k=0; k<=A; k++)
                {
                    if(k - cnt < 0)
                        continue;

                    dp[i][j][k] += dp[i-1][j][k-cnt];
                    dp[i][j][k] += dp[i][j-1][k-cnt];
                }
            }
        }

        System.out.println(dp[N][M][A]);
    }
}
