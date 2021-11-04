import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-04
 * Time: 오후 8:43
 */

public class Q3067
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int[] ary = new int[21];
            int[] dp = new int[10001];
            int N = Integer.parseInt(br.readLine());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            dp[0] = 1;
            for(int i=0; i<N; i++)
            {
                for(int j=ary[i]; j<=M; j++)
                    dp[j] += dp[j-ary[i]];
            }

            sb.append(dp[M]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
