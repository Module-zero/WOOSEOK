/*
최소비용 구하기

https://www.acmicpc.net/problem/1916
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
 * Date: 2021-04-29
 * Time: 오전 1:51
 */

public class Q1916
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

        public int compareTo(PQ p)
        {
            return d - p.d;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int INF = 1000000000;
        int[] dist = new int[1001];
        for(int i=1; i<=N; i++)
            dist[i] = INF;

        boolean[] check = new boolean[1001];
        ArrayList<Temp>[] list = new ArrayList[1001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        while(M-- > 0)
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

        dist[s] = 0;
        PriorityQueue<PQ> pq = new PriorityQueue<>();
        pq.add(new PQ(0, s));
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
                    pq.add(new PQ(dist[t.to], t.to));
                }
            }
        }

        System.out.println(dist[e]);
    }
}
