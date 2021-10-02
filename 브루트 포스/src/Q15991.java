import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-01
 * Time: 오후 3:40
 */

public class Q15991
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        long[] dp = new long[100001];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 2;
        dp[4] = 3;
        dp[5] = 3;

        for(int i=6; i<=100000; i++)
            dp[i] = (dp[i-2] + dp[i-4] + dp[i-6]) % 1000000009;

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            sb.append(dp[n]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
