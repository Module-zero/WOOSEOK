import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-08
 * Time: 오후 7:42
 */

public class Q17216
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] dp = new int[1001];
        int ans = 0;
        for(int i=0; i<N; i++)
        {
            dp[i] = ary[i];
            for(int j=0; j<i; j++)
            {
                if(ary[j] <= ary[i])
                    continue;

                dp[i] = Integer.max(dp[i], dp[j] + ary[i]);
            }

            ans = Integer.max(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
