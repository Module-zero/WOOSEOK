import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-15
 * Time: 오전 12:21
 */

public class Q2056_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] time = new int[10001];

        int N = Integer.parseInt(br.readLine());
        int[] deg = new int[10001];
        int[] dp = new int[10001];
        ArrayList<Integer>[] list = new ArrayList[10001];
        for(int i=1; i<=10000; i++)
            list[i] = new ArrayList<>();

        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            dp[i] = time[i];
            int num = Integer.parseInt(st.nextToken());
            while(num-- > 0)
            {
                int prev = Integer.parseInt(st.nextToken());
                list[prev].add(i);
                deg[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            if(deg[i] == 0)
                queue.add(i);
        }

        int ans = 0;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next : list[tmp])
            {
                dp[next] = Integer.max(dp[next], dp[tmp] + time[next]);

                deg[next]--;
                if(deg[next] == 0)
                    queue.add(next);
            }

            ans = Integer.max(ans, dp[tmp]);
        }

        System.out.println(ans);
    }
}
