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
 * Date: 2021-10-18
 * Time: 오후 3:06
 */

public class Q2056
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] time = new int[10001];
        ArrayList<Integer>[] list = new ArrayList[10001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        int[] deg = new int[10001];
        int[] dp = new int[10001];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            time[i] = Integer.parseInt(st.nextToken());
            dp[i] = time[i];
            int num = Integer.parseInt(st.nextToken());

            while(num-- > 0)
            {
                int next = Integer.parseInt(st.nextToken());
                list[next].add(i);
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
