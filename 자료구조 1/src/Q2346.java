/*
풍선 터뜨리기

https://www.acmicpc.net/problem/2346
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 10:14
 */

public class Q2346
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Deque<int[]> queue = new ArrayDeque<>();
        for(int i=1; i<=N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            queue.add(new int[]{num, i});
        }

        StringBuffer sb = new StringBuffer();
        boolean reverse = false;
        while(!queue.isEmpty())
        {
            int[] tmp;
            if(!reverse)
                tmp = queue.poll();
            else
                tmp = queue.pollLast();

            int num = tmp[0];
            sb.append(tmp[1]).append(' ');

            if(queue.isEmpty())
                break;

            if(num < 0)
            {
                num = -num;
                while(num-- > 1)
                    queue.addFirst(queue.pollLast());

                reverse = true;
            }
            else
            {
                while(num-- > 1)
                    queue.add(queue.poll());

                reverse = false;
            }
        }

        System.out.println(sb.toString());
    }
}
