import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-03
 * Time: 오후 5:28
 */

public class Q2758
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();

        long[][] dp = new long[11][2001];
        dp[1][1] = 1;
        for(int i=0; i<=2000; i++)
            dp[0][i] = 1L;

        for(int i=1; i<=10; i++)
        {
            for(int j=1; j<=2000; j++)
                dp[i][j] = dp[i-1][j/2] + dp[i][j-1];
        }

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
