import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 11:43
 */

public class Q1446
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] dp = new int[10001];
        ArrayList<int[]>[] list = new ArrayList[10001];
        int INF = 1000000000;
        for(int i=0; i<10001; i++)
        {
            list[i] = new ArrayList<>();
            dp[i] = INF;
        }

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[s].add(new int[]{e, d});
        }

        dp[0] = 0;
        for(int i=0; i<=D; i++)
        {
            if(i != 0)
                dp[i] = Integer.min(dp[i], dp[i-1] + 1);

            if(list[i].isEmpty())
                continue;

            for(int[] tmp : list[i])
                dp[tmp[0]] = Integer.min(dp[tmp[0]], tmp[1] + dp[i]);
        }

        System.out.println(dp[D]);
    }
}
