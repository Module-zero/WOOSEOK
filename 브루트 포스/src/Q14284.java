import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-07-01
 * Time: 오후 11:48
 */

public class Q14284
{
    public static class Temp implements Comparable<Temp>
    {
        int b;
        int c;

        public Temp(int b, int c)
        {
            this.b = b;
            this.c = c;
        }

        public int compareTo(Temp temp)
        {
            return c - temp.c;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        ArrayList<Temp>[] list = new ArrayList[5001];
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Temp(b, c));
            list[b].add(new Temp(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        int[] dist = new int[5001];
        for(int i=0; i<=n; i++)
            dist[i] = Integer.MAX_VALUE;

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(Temp tmp : list[s])
        {
            pq.add(tmp);
            dist[tmp.b] = tmp.c;

            while(!pq.isEmpty())
            {
                Temp e = pq.poll();
                if(dist[e.b] < e.c)
                    continue;

                for(Temp next : list[e.b])
                {
                    int cost = next.c + e.c;
                    if(cost < dist[next.b])
                    {
                        dist[next.b] = cost;
                        pq.add(new Temp(next.b, cost));
                    }
                }
            }
        }

        System.out.println(dist[t]);
    }
}
