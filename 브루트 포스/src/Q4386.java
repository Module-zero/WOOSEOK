import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오전 12:02
 */

public class Q4386
{
    static class Temp implements Comparable<Temp>
    {
        int to;
        double d;

        public Temp(int to, double d)
        {
            this.to = to;
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

        boolean[] check = new boolean[101];
        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        queue.add(0);

        double ans = 0;
        while(!queue.isEmpty())
        {
            int t = queue.poll();
            check[t] = true;

            for(int j=0; j<n; j++)
            {
                if(check[j])
                    continue;

                double dx = ary[t][0] - ary[j][0];
                double dy = ary[t][1] - ary[j][1];
                pq.add(new Temp(j, Math.sqrt(dx*dx+dy*dy)));
            }

            while(!pq.isEmpty())
            {
                Temp tmp = pq.poll();

                if(!check[tmp.to])
                {
                    check[tmp.to] = true;
                    queue.add(tmp.to);
                    ans += tmp.d;
                    break;
                }
            }
        }

        System.out.println(String.format("%.2f", ans));
    }
}
