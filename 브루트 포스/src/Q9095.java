/*
1, 2, 3 더하기

https://www.acmicpc.net/problem/9095
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 9:15
 */

public class Q9095
{
    public static int foo(int sum, int goal)
    {
        if(sum > goal) return 0;
        if(sum == goal) return 1;

        int now = 0;
        for(int i=1; i<=3; i++)
            now += foo(sum+i, goal);

        return now;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            System.out.println(foo(0, n));
        }
    }
}
