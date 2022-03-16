import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-15
 * Time: 오후 11:15
 */

public class Q17396
{
    static class PQ implements Comparable<PQ>
    {
        long d;
        int i;

        public PQ(long d, int i)
        {
            this.d = d;
            this.i = i;
        }

        @Override
        public int compareTo(PQ o)
        {
            return Long.compare(d, o.d);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] a = new int[100001];
        for(int i=0; i<N; i++)
            a[i] = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] list = new ArrayList[100001];
        for(int i=0; i<N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            list[start].add(new int[]{end, cost});
            list[end].add(new int[]{start, cost});
        }

        long INF = Long.MAX_VALUE;
        long[] dist = new long[100001];
        for(int i=0; i<N; i++)
            dist[i] = INF;

        PriorityQueue<PQ> pq = new PriorityQueue<>();
        boolean[] check = new boolean[100001];
        pq.add(new PQ(0, 0));
        dist[0] = 0;

        while(!pq.isEmpty())
        {
            PQ tmp = pq.poll();

            if(check[tmp.i])
                continue;

            check[tmp.i] = true;
            for(int[] next : list[tmp.i])
            {
                if(check[next[0]] || (next[0] != N-1 && a[next[0]] == 1))
                    continue;

                if(dist[next[0]] > dist[tmp.i] + next[1])
                {
                    dist[next[0]] = dist[tmp.i] + next[1];
                    pq.add(new PQ(dist[next[0]], next[0]));
                }
            }
        }

        System.out.println((dist[N-1] == INF) ? -1 : dist[N-1]);
    }
}
