/*
별 찍기 - 11

https://www.acmicpc.net/problem/2448
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 2:04
 */

public class Q2448
{
    static char[][] ary = new char[1024*3+1][1024*3+1];

    public static void foo(int y, int x, int n)
    {
        if(n == 1)
            return;

        for(int )
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        foo(0, 0, N);
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                System.out.print(ary[i][j]);

            System.out.println();
        }
    }
}
