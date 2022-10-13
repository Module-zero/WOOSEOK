import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-17
 * Time: 오전 12:45
 */

public class Q18223
{
    static class PQ implements Comparable<PQ>
    {
        int d;
        int i;
        boolean isOk;

        public PQ(int d, int i, boolean isOk)
        {
            this.d = d;
            this.i = i;
            this.isOk = isOk;
        }

        public int compareTo(PQ o)
        {
            return d - o.d;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] list = new ArrayList[5001];
        for(int i=1; i<=V; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new int[]{b, c});
            list[b].add(new int[]{a, c});
        }

        int INF = 1000000000;
        int[] dist = new int[5001];
        for(int i=1; i<=V; i++)
            dist[i] = INF;

        PriorityQueue<PQ> pq = new PriorityQueue<PQ>();
        dist[0] = 0;
        pq.add(new PQ(0, 1, false));
        while(!pq.isEmpty())
        {
            PQ tmp = pq.poll();
            if(tmp.d > dist[tmp.i])
                continue;

            if(tmp.i == P)
                tmp.isOk = true;

            dist[tmp.i] = tmp.d;
            if(tmp.i == V && tmp.isOk)
            {
                System.out.println("SAVE HIM");
                return;
            }

            for(int[] next : list[tmp.i])
                pq.add(new PQ(tmp.d + next[1], next[0], tmp.isOk));
        }

        System.out.println("GOOD BYE");
    }
}
