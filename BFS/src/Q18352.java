/*
특정 거리의 도시 찾기

https://www.acmicpc.net/problem/18352
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-14
 * Time: 오후 4:21
 */

public class Q18352
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[300001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            list[A].add(B);
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] dist = new int[300001];
        for(int i=1; i<=N; i++)
            dist[i] = -1;

        dist[X] = 0;
        queue.add(X);
        PriorityQueue<Integer> ans = new PriorityQueue<>();
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int i : list[tmp])
            {
                if(dist[i] != -1)
                    continue;

                queue.add(i);
                dist[i] = dist[tmp] + 1;
                if(dist[i] == K)
                    ans.add(i);
            }
        }

        if(ans.isEmpty())
            System.out.println(-1);
        else
        {
            StringBuffer sb = new StringBuffer();
            while(!ans.isEmpty())
                sb.append(ans.poll()).append('\n');

            System.out.print(sb.toString());
        }
    }
}
