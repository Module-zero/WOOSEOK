import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오후 3:58
 */

public class Q17212
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[100001];
        int[] coin = {1, 2, 5, 7};
        for(int i=1; i<=N; i++)
            dp[i] = 150000;

        for(int i=0; i<4; i++)
        {
            for(int j=coin[i]; j<=N; j++)
                dp[j] = Integer.min(dp[j], dp[j-coin[i]] + 1);
        }

        System.out.println(dp[N]);
    }
}
