import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-03-26
 * Time: 오후 4:03
 */

public class jeonka3
{
    static class Coffee implements Comparable<Coffee>
    {
        int idx;
        int endTime;

        public Coffee(int idx, int endTime)
        {
            this.idx = idx;
            this.endTime = endTime;
        }

        @Override
        public int compareTo(Coffee o)
        {
            if(this.endTime == o.endTime)
                return idx - o.idx;
            else
                return endTime - o.endTime;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Coffee> pq = new PriorityQueue<>();
        pq.add(new Coffee(1, 4));
        pq.add(new Coffee(2, 2));
        pq.add(new Coffee(3, 2));

        while(!pq.isEmpty())
        {
            System.out.println(pq.peek().idx + " : " + pq.poll().endTime);
        }
    }
}
