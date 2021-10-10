import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-10
 * Time: 오후 4:24
 */

public class Q1106
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] money = new int[21];
        int[] people = new int[21];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            money[i] = Integer.parseInt(st.nextToken());
            people[i] = Integer.parseInt(st.nextToken());
        }

        int ans = Integer.MAX_VALUE;
        int[] dp = new int[1101];
        for(int i=1; i<=C+100; i++)
        {
            dp[i] = 1000000;

            for(int j=0; j<N; j++)
            {
                if(people[j] > i)
                    continue;

                dp[i] = Integer.min(dp[i], dp[i-people[j]] + money[j]);
            }

            if(i >= C)
                ans = Integer.min(ans, dp[i]);
        }

        System.out.println(ans);
    }
}
