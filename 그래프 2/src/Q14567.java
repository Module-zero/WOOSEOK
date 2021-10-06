/*
선수과목 (Prerequisite)

https://www.acmicpc.net/problem/14567
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
 * Date: 2021-05-01
 * Time: 오전 12:01
 */

public class Q14567
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
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            list[A].add(B);
            ind[B]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] answer = new int[1001];
        for(int i=1; i<=N; i++)
        {
            if(ind[i] == 0)
            {
                queue.add(i);
                answer[i] = 1;
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next : list[tmp])
            {
                ind[next]--;

                if(ind[next] == 0)
                {
                    queue.add(next);
                    answer[next] = answer[tmp] + 1;
                }
            }

        }

        for(int i=1; i<=N; i++)
            sb.append(answer[i]).append(' ');

        System.out.println(sb.toString());
    }
}
