import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-05
 * Time: 오후 3:37
 */

public class Q1277
{
    static class Temp implements Comparable<Temp>
    {
        int v;
        double d;

        public Temp(int v, double d)
        {
            this.v = v;
            this.d = d;
        }

        public int compareTo(Temp t)
        {
            return Double.compare(d, t.d);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        double M = Double.parseDouble(br.readLine());

        int[][] ary = new int[1001][2];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ary[i][0] = x;
            ary[i][1] = y;
        }

        double[][] dist = new double[1001][1001];
        for(int i=1; i<=N-1; i++)
        {
            for(int j=i+1; j<=N; j++)
            {
                long dx = ary[i][0] - ary[j][0];
                long dy = ary[i][1] - ary[j][1];
                dist[i][j] = dist[j][i] = Math.sqrt(dx*dx + dy*dy);
            }
        }

        while(W-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            dist[a][b] = dist[b][a] = 0;
        }

        double[] d = new double[1001];
        for(int i=1; i<=N; i++)
            d[i] = Double.MAX_VALUE;

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        pq.add(new Temp(1, 0));

        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            for(int i=1; i<=N; i++)
            {
                double newd = tmp.d + dist[tmp.v][i];
                if(Double.compare(dist[tmp.v][i], M) >= 0)
                    continue;

                if(Double.compare(newd, d[i]) < 0)
                {
                    d[i] = newd;
                    pq.add(new Temp(i, newd));
                }
            }
        }

        System.out.println((long)(d[N]*1000));
    }
}
