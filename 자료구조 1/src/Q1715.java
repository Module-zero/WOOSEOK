/*
카드 정렬하기

https://www.acmicpc.net/problem/1715
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-21
 * Time: 오후 8:43
 */

public class Q1715
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
            pq.add(Integer.parseInt(br.readLine()));

        int ans = 0;
        while(pq.size() != 1)
        {
            int n1 = pq.poll();
            int n2 = pq.poll();

            int num = n1 + n2;
            pq.add(num);
            ans += num;
        }

        System.out.println(ans);
    }
}
