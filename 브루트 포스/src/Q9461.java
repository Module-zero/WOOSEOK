import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-28
 * Time: 오후 12:56
 */

public class Q9461
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[101];
        dp[0] = dp[1] = dp[2] = dp[3] = 1;
        dp[4] = dp[5] = 2;
        for(int i=6; i<=100; i++)
            dp[i] = dp[i-1] + dp[i-5];

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            sb.append(dp[N]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
