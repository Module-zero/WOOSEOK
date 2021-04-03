import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-20
 * Time: 오후 2:16
 */

public class scf2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int[] ary = new int[51];
        for(int i=1; i<=N; i++)
            ary[i] = str.charAt(i-1) - '0';

        long[] dp = new long[51];
        dp[1] = 1;
        for(int i=2; i<=N; i++)
        {
            if(ary[i] == 0)
                continue;

            dp[i] = dp[i-1] + dp[i-2];
        }

        System.out.println(dp[N]);
    }
}
