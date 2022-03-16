import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 4:02
 */

public class Q12026
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int[] dp = new int[1001];
        int INF = 100000000;
        for(int i=0; i<N; i++)
            dp[i] = INF;

        dp[0] = 0;
        for(int i=0; i<N-1; i++)
        {
            char cur = str.charAt(i);
            char next = 'B';
            switch(cur)
            {
                case 'B':
                    next = 'O';
                    break;
                case 'O':
                    next = 'J';
                    break;
            }

            for(int j=i+1; j<N; j++)
            {
                if(str.charAt(j) != next)
                    continue;

                int k = j - i;
                dp[j] = Integer.min(dp[j], dp[i] + k*k);
            }
        }

        System.out.println((dp[N-1] == INF) ? -1 : dp[N-1]);
    }
}
