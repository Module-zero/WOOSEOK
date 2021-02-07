/*
카드 합체 놀이

https://www.acmicpc.net/problem/15903
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오후 3:51
 */

public class Q15903
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            pq.add(Long.parseLong(st.nextToken()));

        for(int i=0; i<m; i++)
        {
            long x = pq.poll();
            long y = pq.poll();

            long sum = x + y;
            pq.add(sum);
            pq.add(sum);
        }

        long ans = 0;
        while(!pq.isEmpty())
            ans += pq.poll();

        System.out.println(ans);
    }
}
