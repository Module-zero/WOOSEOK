import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-06
 * Time: 오전 2:36
 */

public class Q1455
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j) - '0';
        }

        int[][] dp = new int[101][101];

        for(int i=N-1; i>=0; i--)
        {
            for(int j=M-1; j>=0; j--)
            {
                dp[i][j] = dp[i+1][j] + dp[i][j+1] - dp[i+1][j+1];

                if((ary[i][j] + dp[i][j]) % 2 == 1)
                    dp[i][j]++;
            }
        }

        System.out.println(dp[0][0]);
    }
}
