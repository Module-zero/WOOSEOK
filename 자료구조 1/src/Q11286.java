/*
절댓값 힙

https://www.acmicpc.net/problem/11286
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 4:56
 */

public class Q11286
{
    static class Temp implements Comparable<Temp>
    {
        int x;

        public Temp(int x)
        {
            this.x = x;
        }

        @Override
        public int compareTo(Temp o)
        {
            int tx = Math.abs(x);
            int ox = Math.abs(o.x);

            if(tx == ox)
                return x - o.x;
            else
                return tx - ox;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(num == 0)
            {
                if(pq.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(pq.poll().x).append('\n');
            }
            else
                pq.add(new Temp(num));
        }

        System.out.print(sb.toString());
    }
}
