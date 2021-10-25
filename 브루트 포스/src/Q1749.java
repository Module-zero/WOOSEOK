import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-25
 * Time: 오후 1:13
 */

public class Q1749
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[201][201];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            for(int j=1; j<=M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[201][201];
        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                dp[i][j] = dp[i][j-1] + dp[i-1][j] - dp[i-1][j-1] + ary[i][j];
            }
        }

        for(int si=1; si<=N; si++)
        {
            for(int sj=1; sj<=M; sj++)
            {
                for(int ei=si; ei<=N; ei++)
                {
                    for(int ej=sj; ej<=M; ej++)
                    {
                        int sum = dp[ei][ej] - dp[si-1][ej] - dp[ei][sj-1] + dp[si-1][sj-1];
                        ans = Integer.max(ans, sum);
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
