import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-16
 * Time: 오후 2:36
 */

public class Q1374
{
    static class Temp
    {
        int num;
        int start;
        int end;

        public Temp(int num, int start, int end)
        {
            this.num = num;
            this.start = start;
            this.end = end;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Temp> pq1 = new PriorityQueue<>(100001, new Comparator<Temp>()
        {
            @Override
            public int compare(Temp o1, Temp o2)
            {
                return o1.start - o2.start;
            }
        });

        PriorityQueue<Temp> pq2 = new PriorityQueue<>(100001, new Comparator<Temp>()
        {
            @Override
            public int compare(Temp o1, Temp o2)
            {
                return o1.end - o2.end;
            }
        });

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq1.add(new Temp(num, start, end));
        }

        while(!pq1.isEmpty())
        {
            Temp t = pq1.poll();

            if(!pq2.isEmpty())
            {
                Temp tmp = pq2.peek();

                if(tmp.end <= t.start)
                    pq2.poll();
            }

            pq2.add(t);
        }

        System.out.println(pq2.size());
    }
}
