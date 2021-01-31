/*
Yangjojang of The Year

https://www.acmicpc.net/problem/11557
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 8:29
 */

public class Q11557
{
    static class Temp implements Comparable<Temp>
    {
        String name;
        int value;

        public Temp(String name, int value)
        {
            this.name = name;
            this.value = value;
        }

        @Override
        public int compareTo(Temp o)
        {
            return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());

            PriorityQueue<Temp> pq = new PriorityQueue<>(Collections.reverseOrder());
            for(int i=0; i<N; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                int value = Integer.parseInt(st.nextToken());
                pq.add(new Temp(name, value));
            }

            sb.append(pq.poll().name).append('\n');
        }

        System.out.print(sb.toString());
    }
}
