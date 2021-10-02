import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-28
 * Time: 오후 11:07
 */

public class Q17484
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[6][6];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][][] dp = new int[6][6][3];
        for(int i=0; i<6; i++)
        {
            for(int j=0; j<6; j++)
            {
                for(int k=0; k<3; k++)
                {
                    if(i == 0)
                        dp[i][j][k] = ary[i][j];
                    else
                        dp[i][j][k] = 9999999;
                }
            }
        }

        for(int i=1; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                for(int k=0; k<3; k++)
                {
                    if(k == 0)
                    {
                        if(j+1 >= M)
                            continue;

                       dp[i][j][k] = Math.min(dp[i-1][j+1][1], dp[i-1][j+1][2]) + ary[i][j];
                    }
                    else if(k == 2)
                    {
                        if(j-1 < 0)
                            continue;

                        dp[i][j][k] = Math.min(dp[i-1][j-1][0], dp[i-1][j-1][1]) + ary[i][j];
                    }
                    else
                        dp[i][j][k] = Math.min(dp[i-1][j][0], dp[i-1][j][2]) + ary[i][j];
                }
            }
        }

        int min = Integer.MAX_VALUE;

        for(int i=0; i<M; i++)
            for(int j=0; j<3; j++)
                min = Math.min(min, dp[N-1][i][j]);

        System.out.println(min);
    }
}
