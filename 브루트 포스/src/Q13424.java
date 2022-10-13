import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-07-01
 * Time: 오후 7:09
 */

public class Q13424
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            ArrayList<int[]>[] list = new ArrayList[1001];
            for(int i=0; i<=1000; i++)
                list[i] = new ArrayList();

            for(int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

                list[a].add(new int[]{b, c});
                list[b].add(new int[]{a, c});
            }

            int K = Integer.parseInt(br.readLine());
            int[] loc = new int[101];
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<K; i++)
                loc[i] = Integer.parseInt(st.nextToken());

            int[][] dist = new int[101][101];
            for(int i=0; i<=N; i++)
            {
                for(int j=0; j<=N; j++)
                    dist[i][j] = Integer.MAX_VALUE;
            }

            PriorityQueue<int[]> pq = new PriorityQueue(new Comparator<int[]>()
            {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return o1[1] - o2[1];
                }
            });

            int[] sum = new int[101];
            for(int i=0; i<K; i++)
            {
                int start = loc[i];
                pq.add(new int[]{start, 0});
                dist[start][start] = 0;
                while(!pq.isEmpty())
                {
                    int[] n = pq.poll();
                    if(dist[start][n[0]] < n[1])
                        continue;

                    for(int[] tmp : list[n[0]])
                    {
                        int cost = n[1] + tmp[1];
                        if(cost < dist[start][tmp[0]])
                        {
                            dist[start][tmp[0]] = cost;
                            pq.add(new int[]{tmp[0], cost});
                        }
                    }
                }
            }

            int ans = 0;
            int min = Integer.MAX_VALUE;
            for(int i=1; i<=N; i++)
            {
                for(int j=0; j<K; j++)
                    sum[i] += dist[loc[j]][i];

                if(sum[i] < min)
                {
                    min = sum[i];
                    ans = i;
                }
            }

            System.out.println(ans);
        }
    }
}
