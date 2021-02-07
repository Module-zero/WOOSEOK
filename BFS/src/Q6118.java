/*
숨바꼭질

https://www.acmicpc.net/problem/6118
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
 * Date: 2021-02-07
 * Time: 오후 3:59
 */

public class Q6118
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[20001];
        for(int i=0; i<=20000; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
            list[b].add(a);
        }

        int[] dist = new int[20001];
        for(int i=0; i<=20000; i++)
            dist[i] = -1;

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        dist[1] = 0;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            int size = list[tmp].size();
            for(int i=0; i<size; i++)
            {
                int next = list[tmp].get(i);
                if(dist[next] == -1)
                {
                    queue.add(next);
                    dist[next] = dist[tmp] + 1;
                }
            }
        }

        int cnt = 0;
        int num = 0;
        int d = 0;

        for(int i=1; i<=N; i++)
        {
            if(dist[i] > d)
            {
                cnt = 1;
                d = dist[i];
                num = i;
            }
            else if(dist[i] == d)
                cnt++;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(num).append(' ').append(d).append(' ').append(cnt);

        System.out.println(sb.toString());
    }
}
