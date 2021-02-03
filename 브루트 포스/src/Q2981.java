/*
검문

https://www.acmicpc.net/problem/2981
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 12:47
 */

public class Q2981
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ary = new int[101];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        Arrays.sort(ary, 0, N);

        int gcd = ary[1] - ary[0];
        for(int i=1; i<N; i++)
        {
            int diff = ary[i] - ary[i-1];

            int a = gcd;
            int b = diff;
            while(b > 0)
            {
                int r = a % b;
                a = b;
                b = r;
            }

            gcd = a;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=2; i*i<=gcd; i++)
        {
            if(gcd % i == 0)
            {
                pq.add(i);
                pq.add(gcd/i);
            }
        }

        StringBuffer sb = new StringBuffer();
        int prev = 0;
        while(!pq.isEmpty())
        {
            int num = pq.poll();
            if(num == prev)
                continue;
            sb.append(num).append(' ');
            prev = num;
        }

        sb.append(gcd);

        System.out.println(sb.toString());
    }
}
