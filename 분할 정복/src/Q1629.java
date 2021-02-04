/*
곱셈

https://www.acmicpc.net/problem/1629
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 10:35
 */

public class Q1629
{
    public static long foo(long a, long b, long c)
    {
        if(b == 0)
            return 1;

        long value = foo(a, b/2, c);
        value = value * value % c;

        if(b % 2 == 0)
            return value;
        else
            return value * a % c;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long C = Long.parseLong(st.nextToken());

        System.out.println(foo(A, B, C));
    }
}
