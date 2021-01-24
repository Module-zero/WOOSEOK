/*
요세푸스 문제 0

https://www.acmicpc.net/problem/11866
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-23
 * Time: 오후 11:06
 */

public class Q11866
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        sb.append('<');

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
            queue.add(i);

        while(queue.size() != 1)
        {
            for(int i=0; i<K-1; i++)
                queue.add(queue.poll());

            sb.append(queue.poll()).append(", ");
        }

        sb.append(queue.poll()).append('>');

        System.out.println(sb.toString());
    }
}
