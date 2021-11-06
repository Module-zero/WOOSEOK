import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오전 12:20
 */

public class Q4386_kruskal
{
    static class Temp implements Comparable<Temp>
    {
        int from;
        int to;
        double d;

        public Temp(int from, int to, double d)
        {
            this.from = from;
            this.to = to;
            this.d = d;
        }

        public int compareTo(Temp t)
        {
            return Double.compare(d, t.d);
        }
    }

    static int[] p = new int[101];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;

        p[n] = find(p[n]);
        return p[n];
    }

    public static boolean merge(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(a == b)
            return false;

        if(p[b] < p[a])
        {
            int tmp = b;
            b = a;
            a = tmp;
        }

        p[a] += p[b];
        p[b] = a;
        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[][] ary = new double[101][2];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            ary[i][0] = x;
            ary[i][1] = y;
        }

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<n-1; i++)
        {
            for(int j=i+1; j<n; j++)
            {
                double dx = ary[i][0] - ary[j][0];
                double dy = ary[i][1] - ary[j][1];

                pq.add(new Temp(i, j, Math.sqrt(dx*dx + dy*dy)));
            }
        }
        for(int i=0; i<n; i++)
            p[i] = -1;

        double ans = 0;
        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            if(merge(tmp.from, tmp.to))
                ans += tmp.d;
        }

        System.out.println(String.format("%.2f", ans));
    }
}
