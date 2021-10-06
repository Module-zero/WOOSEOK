/*
최단경로

https://www.acmicpc.net/problem/1753
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
 * Date: 2021-05-01
 * Time: 오전 12:40
 */

public class Q1753
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

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        ArrayList<Temp>[] list = new ArrayList[20001];
        for(int i=1; i<=V; i++)
            list[i] = new ArrayList<>();

        int INF = 1000000000;
        int[] dist = new int[20001];
        for(int i=1; i<=V; i++)
            dist[i] = INF;

        while(E-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            list[u].add(new Temp(v, w));
        }

        boolean[] check = new boolean[20001];
        dist[K] = 0;
        PriorityQueue<PQ> pq = new PriorityQueue<>();
        pq.add(new PQ(0, K));

        while(!pq.isEmpty())
        {
            PQ tmp = pq.poll();
            if(check[tmp.i])
                continue;

            check[tmp.i] = true;
            for(Temp next : list[tmp.i])
            {
                if(dist[next.to] > dist[tmp.i] + next.cost)
                {
                    dist[next.to] = dist[tmp.i] + next.cost;
                    pq.add(new PQ(dist[next.to], next.to));
                }
            }
        }

        for(int i=1; i<=V; i++)
            System.out.println(dist[i] == INF ? "INF" : dist[i]);
    }
}
