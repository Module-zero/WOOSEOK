import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-12
 * Time: 오후 8:11
 */

public class test2
{
    static class Temp implements Comparable<Temp>
    {
        int S;
        int F;

        public Temp(int S, int F)
        {
            this.S = S;
            this.F = F;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(this.F < o.F)
                return -1;
            else if(this.F > o.F)
                return 1;
            else
                return this.S - o.S;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int S = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            pq.add(new Temp(S, F));
        }

        int cnt = 0;
        int cur = 0;
        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            if(cur <= tmp.S)
            {
                cnt++;
                cur = tmp.F;
            }
        }

        System.out.println(cnt);
    }
}
