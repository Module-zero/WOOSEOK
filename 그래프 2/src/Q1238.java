/*
파티

https://www.acmicpc.net/problem/1238
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-05-01
 * Time: 오전 12:55
 */

public class Q1238
{
    static class Temp implements Comparable<Temp>
    {
        int d;
        int i;

        public Temp(int d, int i)
        {
            this.d = d;
            this.i = i;
        }

        @Override
        public int compareTo(Temp o)
        {
            return d - o.d;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Temp>[] list = new ArrayList[1001];
        ArrayList<Temp>[] list2 = new ArrayList[1001];
        for(int i=1; i<=N; i++)
        {
            list[i] = new ArrayList<>();
            list2[i] = new ArrayList<>();
        }

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            list[s].add(new Temp(t, e));
            list2[e].add(new Temp(t, s));
        }

        int INF = 1000000000;
        int answer = 0;
        int[] dist = new int[1001];
        int[] dist2 = new int[1001];

        for(int i=1; i<=N; i++)
        {
            dist[i] = INF;
            dist2[i] = INF;
        }

        dist[X] = 0;
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        pq.add(new Temp(0, X));

        boolean[] check = new boolean[1001];

        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();
            if(check[tmp.i])
                continue;

            check[tmp.i] = true;
            for(Temp next : list[tmp.i])
            {
                if(dist[next.i] > dist[tmp.i] + next.d)
                {
                    dist[next.i] = dist[tmp.i] + next.d;
                    pq.add(new Temp(dist[next.i], next.i));
                }
            }
        }

        pq = new PriorityQueue<>();
        pq.add(new Temp(0, X));
        check = new boolean[1001];
        dist2[X] = 0;

        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();
            if(check[tmp.i])
                continue;

            check[tmp.i] = true;
            for(Temp next : list2[tmp.i])
            {
                if(dist2[next.i] > dist2[tmp.i] + next.d)
                {
                    dist2[next.i] = dist2[tmp.i] + next.d;
                    pq.add(new Temp(dist2[next.i], next.i));
                }
            }
        }

        for(int i=1; i<=N; i++)
            answer = Integer.max(answer, dist[i] + dist2[i]);

        System.out.println(answer);
    }
}
