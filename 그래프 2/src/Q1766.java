/*
문제집

https://www.acmicpc.net/problem/1766
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
 * Date: 2021-04-26
 * Time: 오전 12:03
 */

public class Q1766
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int[] indeg = new int[32001];
        ArrayList<Integer>[] list = new ArrayList[32001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            indeg[b] += 1;
        }

        for(int i=1; i<=N; i++)
        {
            if(indeg[i] == 0)
                pq.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            int tmp = pq.poll();

            for(int i : list[tmp])
            {
                indeg[i]--;

                if(indeg[i] == 0)
                    pq.add(i);
            }

            sb.append(tmp).append(' ');
        }

        System.out.println(sb.toString());
    }
}
