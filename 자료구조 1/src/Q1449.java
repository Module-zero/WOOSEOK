/*
수리공 항승

https://www.acmicpc.net/problem/1449
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-04
 * Time: 오후 11:55
 */

public class Q1449
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(st.nextToken()));

        int cnt = 0;
        while(!pq.isEmpty())
        {
            int start = pq.peek();

            int end = pq.poll();
            while(!pq.isEmpty() && pq.peek() - start + 1 <= L)
                end = pq.poll();

            cnt++;
        }

        System.out.println(cnt);
    }
}
