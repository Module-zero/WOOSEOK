/*
하노이 탑

https://www.acmicpc.net/problem/1914
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-01
 * Time: 오후 6:11
 */

public class Q1914
{
    static StringBuffer sb = new StringBuffer();

    public static void foo(int size, int cur, int next)
    {
        if(size == 0)
            return;

        foo(size-1, cur, 6-cur-next);
        sb.append(cur).append(' ').append(next).append('\n');
        foo(size-1, 6-cur-next, next);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        BigInteger K = new BigInteger("2");
        System.out.println(K.pow(N).subtract(new BigInteger("1")));

        if(N <= 20)
        {
            foo(N, 1, 3);
            System.out.print(sb.toString());
        }
    }
}
