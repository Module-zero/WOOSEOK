/*
사분면

https://www.acmicpc.net/problem/1891
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-08
 * Time: 오후 7:51
 */

public class Q1891
{
    static int d;
    static String num;
    static long x;
    static long y;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int id, long r, long c, long size)
    {
        if(size == 1)
        {
            long max = (long)Math.pow(2, num.length());
            long newR = r + y;
            if(newR < 0 || newR >= max)
            {
                System.out.println(-1);
                return;
            }

            long newC = c + x;
            if(newC < 0 || newC >= max)
            {
                System.out.println(-1);
                return;
            }

            foofoo(0, 0, newR, newC, max);

            return;
        }

        switch(num.charAt(id))
        {
            case '1':
                foo(id + 1, r + size/2, c + size/2, size/2);
                break;
            case '2':
                foo(id + 1, r + size/2, c, size/2);
                break;
            case '3':
                foo(id + 1, r, c, size/2);
                break;
            case '4':
                foo(id + 1, r, c + size/2, size/2);
                break;
        }
    }

    public static void foofoo(long left, long down, long r, long c, long size)
    {
        if(size == 1)
        {
            System.out.println(sb.toString());
            return;
        }

        int n;
        size /= 2;

        if(c < left + size)
        {
            // 3사분면
            if(r < down + size)
                n = 3;
            // 2사분면
            else
            {
                down += size;
                n = 2;
            }
        }
        else
        {
            // 4사분면
            if(r < down + size)
            {
                left += size;
                n = 4;
            }
            // 1사분면
            else
            {
                left += size;
                down += size;
                n = 1;
            }
        }

        sb.append(n);
        foofoo(left, down, r, c, size);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        d = Integer.parseInt(st.nextToken());
        num = st.nextToken();

        st = new StringTokenizer(br.readLine());
        x = Long.parseLong(st.nextToken());
        y = Long.parseLong(st.nextToken());

        foo(0, 0, 0, (long)Math.pow(2, num.length()));
    }
}
