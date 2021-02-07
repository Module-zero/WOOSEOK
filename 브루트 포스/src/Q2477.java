/*
참외밭

https://www.acmicpc.net/problem/2477
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오후 6:40
 */

public class Q2477
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<6; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int dir = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());
            queue.add(new int[]{dir, len});
        }

        while(true)
        {
            Iterator<int[]> it = queue.iterator();
            int[] first = it.next();
            int[] second = it.next();
            if(first[0] == it.next()[0] && second[0] == it.next()[0])
                break;

            queue.add(queue.poll());
        }

        queue.poll();
        int small = queue.poll()[1] * queue.poll()[1];
        queue.poll();
        int big = queue.poll()[1] * queue.poll()[1];

        System.out.println(K * (big - small));
    }
}
