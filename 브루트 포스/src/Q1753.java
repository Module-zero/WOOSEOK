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
 * Date: 2021-11-01
 * Time: 오후 2:53
 */

public class Q1753
{
    static class Temp implements Comparable<Temp>
    {
        int b;
        int c;

        public Temp(int b, int c)
        {
            this.b = b;
            this.c = c;
        }

        public int compareTo(Temp o)
        {
            return c - o.c;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        ArrayList<Temp>[] list = new ArrayList[20001];
        for(int i=0; i<=V; i++)
            list[i] = new ArrayList<>();

        int[] d = new int[20001];
        for(int i=0; i<=V; i++)
            d[i] = 999999;

        while(E-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Temp(v, w));
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>(2000, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] - o2[1];
            }
        });

        pq.add(new int[]{K, 0});
        d[K] = 0;
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();

            if(d[tmp[0]] < tmp[1])
                continue;

            for(Temp t : list[tmp[0]])
            {
                int dist = t.c + tmp[1];
                if(dist < d[t.b])
                {
                    d[t.b] = dist;
                    pq.add(new int[]{t.b, dist});
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=V; i++)
        {
            sb.append(d[i] == 999999 ? "INF" : d[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
