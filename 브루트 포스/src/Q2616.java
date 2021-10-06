import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-06
 * Time: 오후 4:01
 */

public class Q2616
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[50001];
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int lim = Integer.parseInt(br.readLine());

        int[] sum = new int[50001];
        for(int i=1; i<=N; i++)
        {
            sum[i] = sum[i - 1] + ary[i];
            if(i >= lim)
                sum[i] -= ary[i-lim];
        }

        int[][] dp = new int[50001][4];
        for(int i=lim; i<=N; i++)
        {
            for(int j=1; j<4; j++)
                dp[i][j] = Integer.max(dp[i-1][j], dp[i-lim][j-1] + sum[i]);
        }

        System.out.println(dp[N][3]);
    }
}
