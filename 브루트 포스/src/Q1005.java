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
 * Time: 오전 12:40
 */

public class Q1005
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            ArrayList<Integer>[] list = new ArrayList[1001];
            int[] D = new int[1001];
            int[] dp = new int[1001];
            for(int i=1; i<=N; i++)
            {
                list[i] = new ArrayList<>();
                D[i] = Integer.parseInt(st.nextToken());
                dp[i] = D[i];
            }

            int[] deg = new int[1001];
            for(int i=0; i<K; i++)
            {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());

                list[X].add(Y);
                deg[Y]++;
            }

            int W = Integer.parseInt(br.readLine());

            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<=N; i++)
            {
                if(deg[i] == 0)
                    queue.add(i);
            }

            while(!queue.isEmpty())
            {
                int tmp = queue.poll();

                for(int next : list[tmp])
                {
                    dp[next] = Integer.max(dp[next], dp[tmp] + D[next]);

                    deg[next]--;
                    if(deg[next] == 0)
                        queue.add(next);
                }
            }

            sb.append(dp[W]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
