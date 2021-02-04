/*
전깃줄

https://www.acmicpc.net/problem/2565
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 3:26
 */

public class Q2565
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ary = new int[501];
        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            ary[A] = B;
        }

        int max = Integer.MIN_VALUE;
        int[] ps = new int[501];
        for(int i=1; i<=500; i++)
        {
            if(ary[i] == 0)
                continue;

            ps[i] = 1;
            int j = i;
            while(j >= 1)
            {
                j--;

                if(ary[j] == 0)
                    continue;

                if(ary[j] < ary[i] && ps[j] + 1 > ps[i])
                    ps[i] = ps[j] + 1;
            }

            max = Integer.max(ps[i], max);
        }

        System.out.println(N - max);
    }
}
