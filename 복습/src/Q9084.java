import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-14
 * Time: 오후 3:52
 */

public class Q9084
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] token = new int[21];
            for(int i=0; i<N; i++)
                token[i] = Integer.parseInt(st.nextToken());

            int M = Integer.parseInt(br.readLine());
            int[] dp = new int[10001];
            for(int i=0; i<N; i++)
            {
                dp[token[i]]++;

                for(int j=token[i]; j<=M; j++)
                    dp[j] += dp[j - token[i]];
            }

            sb.append(dp[M]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
