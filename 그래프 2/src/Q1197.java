/*
최소 스패닝 트리

https://www.acmicpc.net/problem/1197
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-27
 * Time: 오전 1:48
 */

public class Q1197
{
    static class Temp implements Comparable<Temp>
    {
        int from;
        int to;
        int cost;

        public Temp(int from, int to, int cost)
        {
            this.from = from;
            this.to = to;
            this.cost = cost;
        }

        public int compareTo(Temp o)
        {
            return cost - o.cost;
        }
    }

    static int[] p = new int[10001];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;

        return p[n] = find(p[n]);
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b)
            return;

        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        for(int i=1; i<=V; i++)
            p[i] = -1;

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<E; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Temp(A, B, C));
        }

        int answer = 0;

        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            if(find(tmp.from) != find(tmp.to))
            {
                merge(tmp.from, tmp.to);
                answer += tmp.cost;
            }
        }

        System.out.println(answer);
    }
}
