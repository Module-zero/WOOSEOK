/*
전력난

https://www.acmicpc.net/problem/6497
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-27
 * Time: 오후 2:32
 */

public class Q6497
{
    static class Temp implements Comparable<Temp>
    {
        int to;
        int cost;

        public Temp(int to, int cost)
        {
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Temp o)
        {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if(m == 0 && n == 0)
                break;

            ArrayList<Temp>[] list = new ArrayList[200001];
            for(int i=0; i<m; i++)
                list[i] = new ArrayList<>();

            int total = 0;
            while(n-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());

                list[x].add(new Temp(y, z));
                list[y].add(new Temp(x, z));
                total += z;
            }

            PriorityQueue<Temp> pq = new PriorityQueue<>();
            boolean[] check = new boolean[200001];
            check[1] = true;
            for(Temp tmp : list[1])
                pq.add(tmp);

            while(!pq.isEmpty())
            {
                Temp tmp = pq.poll();
                if(check[tmp.to])
                    continue;

                check[tmp.to] = true;
                total -= tmp.cost;

                for(Temp next : list[tmp.to])
                    pq.add(next);
            }

            sb.append(total).append('\n');
        }

        System.out.print(sb.toString());
    }
}
