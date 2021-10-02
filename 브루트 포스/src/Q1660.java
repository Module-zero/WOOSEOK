import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-09-28
 * Time: 오후 6:35
 */

public class Q1660
{
    static int[] tri = new int[501];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] tri = new int[501];
        int i=1;
        while(true)
        {
            tri[i] = i * (i + 1) * (i + 2) / 6;
            if(tri[i] >= 300000)
                break;

            i++;
        }

        int[] dp = new int[300001];
        for(int j=1; j<=300000; j++)
            dp[j] = Integer.MAX_VALUE;

        for(int j=1; j<i; j++)
        {
            dp[tri[j]] = 1;

            for(int k=tri[j]; k<=N; k++)
                dp[k] = Math.min(dp[k], dp[k-tri[j]] + 1);
        }

        System.out.println(dp[N]);
    }
}
