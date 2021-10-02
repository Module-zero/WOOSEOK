import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 2:20
 */

public class Q15992
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        long[][] dp = new long[1001][1001];
        dp[1][1] = 1;
        dp[2][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 2;
        dp[3][3] = 1;

        for(int i=4; i<=1000; i++)
        {
            for(int j=1; j<=i; j++)
            {
                dp[i][j] = (dp[i-1][j-1] + dp[i-2][j-1] + dp[i-3][j-1]) % 1000000009;
            }
        }

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(dp[n][m]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
