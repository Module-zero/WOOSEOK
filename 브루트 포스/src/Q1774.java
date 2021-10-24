import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-24
 * Time: 오후 3:04
 */

public class Q1774
{
    static class Temp implements Comparable<Temp>
    {
        int from;
        int to;
        double dist;

        public Temp(int from, int to, double dist)
        {
            this.from = from;
            this.to = to;
            this.dist = dist;
        }

        public int compareTo(Temp o)
        {
            return Double.compare(dist, o.dist);
        }
    }

    static int[] p = new int[1001];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;

        p[n] = find(p[n]);
        return p[n];
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b)
            return;

        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][2];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            ary[i][0] = Integer.parseInt(st.nextToken());
            ary[i][1] = Integer.parseInt(st.nextToken());
        }

        for(int i=1; i<=N; i++)
            p[i] = -1;

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            merge(a, b);
        }

        double ans = 0;
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=1; i<=N-1; i++)
        {
            for(int j=i+1; j<=N; j++)
            {
                long x = ary[i][0] - ary[j][0];
                long y = ary[i][1] - ary[j][1];
                pq.add(new Temp(i, j, Math.sqrt(x*x + y*y)));
            }
        }

        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            if(find(tmp.from) == find(tmp.to))
                continue;

            merge(tmp.from, tmp.to);
            ans += tmp.dist;
        }

        System.out.println(String.format("%.2f", ans));
    }
}
