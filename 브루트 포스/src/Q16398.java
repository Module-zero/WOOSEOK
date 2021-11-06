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
 * Time: 오전 12:29
 */

public class Q16398
{
    static class Temp implements Comparable<Temp>
    {
        int to;
        int d;

        public Temp(int to, int d)
        {
            this.to = to;
            this.d = d;
        }

        public int compareTo(Temp t)
        {
            return d - t.d;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[1001][1001];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[] check = new boolean[1001];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        PriorityQueue<Temp> pq = new PriorityQueue<>();

        long ans = 0;
        while(!queue.isEmpty())
        {
            int t = queue.poll();
            check[t] = true;

            for(int i=0; i<N; i++)
            {
                if(check[i])
                    continue;

                pq.add(new Temp(i, ary[t][i]));
            }

            while(!pq.isEmpty())
            {
                Temp tmp = pq.poll();

                if(check[tmp.to])
                    continue;

                check[tmp.to] = true;
                queue.add(tmp.to);
                ans += tmp.d;
                break;
            }
        }

        System.out.println(ans);
    }
}
