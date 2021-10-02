/*
네트워크 연결

https://www.acmicpc.net/problem/1922
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
 * Time: 오전 1:23
 */

public class Q1922
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

        @Override
        public int compareTo(Temp o)
        {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Temp>[] list = new ArrayList[1001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        while(M-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Temp(b, c));
            list[b].add(new Temp(a, c));
        }

        PriorityQueue<Temp> pq = new PriorityQueue<>();

        int answer = 0;
        boolean[] check = new boolean[1001];
        check[1] = true;
        for(Temp next : list[1])
            pq.add(next);

        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();
            if(check[tmp.to])
                continue;

            check[tmp.to] = true;
            answer += tmp.cost;
            for(Temp next : list[tmp.to])
                pq.add(next);
        }

        System.out.println(answer);
    }
}
