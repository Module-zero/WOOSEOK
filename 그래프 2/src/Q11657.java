/*
타임머신

https://www.acmicpc.net/problem/11657
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
 * Time: 오전 12:40
 */

public class Q11657
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

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        long[] dist = new long[501];
        for(int i=1; i<=N; i++)
            dist[i] = 1000000000;

        ArrayList<Temp> list = new ArrayList<>();
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());

            list.add(new Temp(A, B, C));
        }

        dist[1] = 0;
        boolean negative = false;
        for(int i=0; i<N; i++)
        {
            for(Temp tmp : list)
            {
                if(dist[tmp.from] != 1000000000 && dist[tmp.to] > dist[tmp.from] + tmp.cost)
                {
                    dist[tmp.to] = dist[tmp.from] + tmp.cost;

                    if(i == N-1)
                        negative = true;
                }
            }
        }

        if(negative)
            System.out.println(-1);
        else
        {
            for(int i=2; i<=N; i++)
                System.out.println(dist[i] == 1000000000? -1 : dist[i]);
        }
    }
}
