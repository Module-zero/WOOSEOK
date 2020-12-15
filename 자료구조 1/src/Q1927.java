/*
최소 힙

https://www.acmicpc.net/problem/1927
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-15
 * Time: 오후 3:34
 */

public class Q1927
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int N = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(num == 0)
            {
                if(heap.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(heap.poll()).append('\n');
            }
            else
                heap.add(num);
        }

        System.out.print(sb.toString());
    }
}
