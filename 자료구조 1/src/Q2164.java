/*
카드2

https://www.acmicpc.net/problem/2164
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-23
 * Time: 오후 10:59
 */

public class Q2164
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
            queue.add(i);

        while(queue.size() != 1)
        {
            queue.poll();
            if(queue.size() == 1)
                break;

            queue.add(queue.poll());
        }

        System.out.println(queue.poll());
    }
}
