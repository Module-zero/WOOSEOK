/*
A → B

https://www.acmicpc.net/problem/16953
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 5:32
 */

public class Q16953
{
    static long A;
    static long B;
    static int min = Integer.MAX_VALUE;

    public static void foo(long num, int cnt)
    {
        if(num > B)
            return;

        if(num == B)
        {
            if(cnt+1 < min)
                min = cnt+1;

            return;
        }

        foo(num*2, cnt+1);
        foo(num*10 + 1, cnt+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        foo(A, 0);

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}
