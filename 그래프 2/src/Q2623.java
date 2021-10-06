/*
음악프로그램

https://www.acmicpc.net/problem/2623
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
 * Time: 오후 2:53
 */

public class Q2623
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] ind = new int[1001];
        ArrayList<Integer>[] list = new ArrayList[1001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int cnt = Integer.parseInt(st.nextToken()) - 1;
            int prev = 0;
            int cur = Integer.parseInt(st.nextToken());
            while(cnt-- > 0)
            {
                prev = cur;
                cur = Integer.parseInt(st.nextToken());

                ind[cur]++;
                list[prev].add(cur);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            if(ind[i] == 0)
                queue.add(i);
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next : list[tmp])
            {
                ind[next]--;
                if(ind[next] == 0)
                    queue.add(next);
            }

            sb.append(tmp).append('\n');
        }

        for(int i=1; i<=N; i++)
        {
            if(ind[i] != 0)
            {
                System.out.println(0);
                return;
            }
        }

        System.out.print(sb.toString());
    }
}
