/*
막대기

https://www.acmicpc.net/problem/1094
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 11:48
 */

public class Q1094
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 64;
        pq.add(64);
        while(sum > X)
        {
            int num = pq.poll();

            int n1 = num / 2;
            if(sum - n1 >= X)
            {
                pq.add(n1);
                sum -= n1;
            }
            else
            {
                pq.add(n1);
                pq.add(n1);
            }
        }

        System.out.println(pq.size());
    }
}
