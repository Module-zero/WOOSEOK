/*
성적 통계

https://www.acmicpc.net/problem/5800
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오전 1:33
 */

public class Q5800
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer>[] pq = new PriorityQueue[101];
        StringBuffer sb = new StringBuffer();
        int K = Integer.parseInt(br.readLine());
        for(int i=1; i<=K; i++)
        {
            sb.append("Class ").append(i).append('\n');

            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            for(int j=0; j<N; j++)
                pq[i].add(Integer.parseInt(st.nextToken()));

            int max = pq[i].poll();
            int min = max;
            int prev = max;
            int gap = 0;
            while(!pq[i].isEmpty())
            {
                int num = pq[i].poll();
                gap = Integer.max(gap, prev - num);
                prev = num;
                min = num;
            }

            sb.append("Max ").append(max).append(", Min ").append(min).append(", Largest gap ").append(gap).append('\n');
        }

        System.out.print(sb.toString());
    }
}
