/*
도시 분할 계획

https://www.acmicpc.net/problem/1647
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
 * Date: 2021-04-30
 * Time: 오후 11:30
 */

public class Q1647
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

        @Override
        public int compareTo(Temp o)
        {
            return cost - o.cost;
        }
    }

    static int[] p = new int[100001];

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
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Temp>[] list = new ArrayList[100001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=1; i<=N; i++)
            p[i] = -1;

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            pq.add(new Temp(A, B, C));
        }

        int answer = 0;
        while(!pq.isEmpty() && N > 2) // N을 마을의 수로 보자.
        {
            Temp tmp = pq.poll();
            int a = tmp.from;
            int b = tmp.to;

            if(find(a) != find(b))
            {
                merge(a, b);
                answer += tmp.cost;
                N--;
            }
        }

        System.out.println(answer);
    }
}
