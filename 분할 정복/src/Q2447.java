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
    static char[][] ary = new char[2200][2200];

    public static void foo(int y, int x, int n)
    {
        if(n == 1)
        {
            ary[y][x] = '*';
            return;
        }

        int mid = n/3;

        for(int i=0; i<3; i++)
        {
            for(int j=0; j<3; j++)
            {
                if(i == 1 && j == 1)
                    continue;

                foo(y + mid * i, x + mid * j, mid);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        foo(0, 0, N);

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(ary[i][j] == '*')
                    sb.append(ary[i][j]);
                else
                    sb.append(' ');
            }

            sb.append('\n');
        }

        System.out.println(sb.toString());
    }
}
