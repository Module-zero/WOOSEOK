/*
최대 힙

https://www.acmicpc.net/problem/11279
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 5:29
 */

public class Q11279
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Integer> heap = new PriorityQueue<>();
        StringBuffer sb = new StringBuffer();
        int N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(br.readLine());

            if(num == 0)
            {
                if(heap.isEmpty())
                    sb.append(0).append('\n');
                else
                    sb.append(-heap.poll()).append('\n');
            }
            else
                heap.add(-num);
        }

        System.out.print(sb.toString());
    }
}
