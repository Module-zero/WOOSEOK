/*
최소비용 구하기 2

https://www.acmicpc.net/problem/11779
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-29
 * Time: 오전 2:07
 */

public class Q11779
{
    static class Temp
    {
        int to;
        int cost;

        public Temp(int to, int cost)
        {
            this.to = to;
            this.cost = cost;
        }
    }

    static class PQ implements Comparable<PQ>
    {
        int d;
        int i;

        public PQ(int d, int i)
        {
            this.d = d;
            this.i = i;
        }

        @Override
        public int compareTo(PQ o)
        {
            return d - o.d;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Temp>[] list = new ArrayList[1001];
        for(int i=1; i<=n; i++)
            list[i] = new ArrayList<>();

        int INF = 1000000000;
        int[] dist = new int[1001];
        for(int i=1; i<=n; i++)
            dist[i] = INF;

        boolean[] check = new boolean[1001];
        while(m-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[s].add(new Temp(e, c));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        PriorityQueue<PQ> pq = new PriorityQueue<>();
        dist[s] = 0;
        pq.add(new PQ(0, s));

        int[] prev = new int[1001];
        prev[s] = -1;
        while(!pq.isEmpty())
        {
            PQ tmp = pq.poll();

            if(check[tmp.i])
                continue;

            check[tmp.i] = true;
            for(Temp t : list[tmp.i])
            {
                if(dist[t.to] > dist[tmp.i] + t.cost)
                {
                    dist[t.to] = dist[tmp.i] + t.cost;
                    prev[t.to] = tmp.i;
                    pq.add(new PQ(dist[t.to], t.to));
                }
            }
        }

        System.out.println(dist[e]);
        Stack<Integer> stack = new Stack<>();
        while(e > 0)
        {
            stack.add(e);
            e = prev[e];
        }

        System.out.println(stack.size());
        while(!stack.isEmpty())
            System.out.print(stack.pop() + " ");
    }
}
