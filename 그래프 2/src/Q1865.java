/*
웜홀

https://www.acmicpc.net/problem/1865
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-29
 * Time: 오전 1:12
 */

public class Q1865
{
    static class Temp
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
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            ArrayList<Temp> list = new ArrayList<>();
            while(M-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                list.add(new Temp(S, E, T));
                list.add(new Temp(E, S, T));
            }

            while(W-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = -Integer.parseInt(st.nextToken());

                list.add(new Temp(S, E, T));
            }

            long[] dist = new long[501];
            int INF = 1000000000;
            for(int i=1; i<=N; i++)
                dist[i] = INF;

            boolean negative = false;

            // 시작점
            boolean[] visited = new boolean[501];
            for(int k=1; k<=N; k++)
            {
                if(visited[k])
                    continue;

                dist[k] = 0;
                visited[k] = true;
                for(int i=1; i<=N; i++)
                {
                    for(Temp tmp : list)
                    {
                        if(dist[tmp.from] != INF && dist[tmp.to] > dist[tmp.from] + tmp.cost)
                        {
                            dist[tmp.to] = dist[tmp.from] + tmp.cost;
                            visited[tmp.to] = true;

                            if(i == N)
                                negative = true;
                        }
                    }
                }
            }

            System.out.println(negative ? "YES" : "NO");
        }
    }
}
