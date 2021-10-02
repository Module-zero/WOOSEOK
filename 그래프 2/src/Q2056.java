/*
작업

https://www.acmicpc.net/problem/2056
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
 * Time: 오전 12:57
 */

public class Q2056
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer>[] list = new ArrayList[10001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        int[] indeg = new int[10001];
        int[] time = new int[10001];
        int[] dp = new int[10001];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            time[i] = Integer.parseInt(st.nextToken());
            dp[i] = time[i];
            int n = Integer.parseInt(st.nextToken());
            while(n-- > 0)
            {
                int prev = Integer.parseInt(st.nextToken());
                list[prev].add(i);
                indeg[i]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            if(indeg[i] == 0)
                queue.add(i);
        }

        int answer = 0;
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next : list[tmp])
            {
                dp[next] = Integer.max(dp[next], dp[tmp] + time[next]);
                indeg[next]--;
                if(indeg[next] == 0)
                    queue.add(next);
            }

            answer = Integer.max(answer, dp[tmp]);
        }

        System.out.println(answer);
    }
}
