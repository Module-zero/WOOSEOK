/*
로프

https://www.acmicpc.net/problem/2217
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-23
 * Time: 오후 11:24
 */

public class Q2217
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(N-- > 0)
            pq.add(Integer.parseInt(br.readLine()));

        int max = Integer.MIN_VALUE;
        while(!pq.isEmpty())
        {
            int size = pq.size();
            int num = pq.poll();
            max = Integer.max(num*size, max);
        }

        System.out.println(max);
    }
}
