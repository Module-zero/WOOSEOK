/*
줄 세우기

https://www.acmicpc.net/problem/2252
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-27
 * Time: 오전 12:52
 */

public class Q2252
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[32001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        int[] indeg = new int[32001];
        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());

            int prev = Integer.parseInt(st.nextToken());
            int next = Integer.parseInt(st.nextToken());

            list[prev].add(next);
            indeg[next]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            if(indeg[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next : list[tmp])
            {
                indeg[next]--;
                if(indeg[next] == 0)
                    queue.add(next);
            }

            sb.append(tmp).append(' ');
        }

        System.out.println(sb.toString());
    }
}
