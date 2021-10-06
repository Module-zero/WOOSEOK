import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-29
 * Time: 오전 1:05
 */

public class Q15993
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[][] dp = new long[100001][2];
        int T = Integer.parseInt(br.readLine());
        dp[1][1] = 1;
        dp[2][0] = 1;
        dp[2][1] = 1;
        dp[3][0] = 2;
        dp[3][1] = 2;

        for(int i=4; i<100001; i++)
        {
            dp[i][0] = (dp[i-1][1] + dp[i-2][1] + dp[i-3][1]) % 1000000009;
            dp[i][1] = (dp[i-1][0] + dp[i-2][0] + dp[i-3][0]) % 1000000009;
        }

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n][1]).append(' ').append(dp[n][0]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
