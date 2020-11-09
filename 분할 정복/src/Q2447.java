/*
별 찍기 - 10

https://www.acmicpc.net/problem/2447
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-08
 * Time: 오후 8:11
 */

public class Q2447
{
    static StringBuilder sb = new StringBuilder();

    public static void foo(int n, char ch)
    {
        if(n == 1)
            sb.append(ch);

        int mid = n / 3;

        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
            {
                if(i >= mid && i < 2*mid && j >= mid && j < 2*mid)
                    foo(n/3, ch);
                else
                    foo(n/3, ch);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int mid = N / 3;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(i >= mid && i < 2*mid && j >= mid && j < 2*mid)
                    foo(N/3, ' ');
                else
                    foo(N/3, '*');
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
