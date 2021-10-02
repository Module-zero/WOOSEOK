/*
게임 개발

https://www.acmicpc.net/problem/1516
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
 * Date: 2021-04-30
 * Time: 오후 11:51
 */

public class Q1516
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ind = new int[501];
        int[] t = new int[501];
        ArrayList<Integer>[] list = new ArrayList[501];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            t[i] = Integer.parseInt(st.nextToken());

            while(true)
            {
                int n = Integer.parseInt(st.nextToken());
                if(n == -1)
                    break;

                ind[i]++;
                list[n].add(i);
            }
        }

        for(int i=1; i<=N; i++)
        {
            if(ind[i] == 0)
                queue.add(i);
        }

        int[] dp = new int[501];
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();
            dp[tmp] += t[tmp];

            for(int next : list[tmp])
            {
                dp[next] = Integer.max(dp[next], dp[tmp]);
                ind[next]--;
                if(ind[next] == 0)
                    queue.add(next);
            }
        }

        for(int i=1; i<=N; i++)
            System.out.println(dp[i]);
    }
}
