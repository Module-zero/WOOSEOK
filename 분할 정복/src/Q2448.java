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
    static char[][] ary = new char[3*1024+1][3*1024*2+1];

    static void foo(int r, int c, int size)
    {
        if(size == 3)
        {
            ary[r][c] = '*';
            ary[r+1][c-1] = '*';
            ary[r+1][c+1] = '*';
            for(int i=-2; i<=2; i++)
                ary[r+2][c+i] = '*';

            return;
        }

        foo(r, c, size/2);
        foo(r + size/2, c - size/2, size/2);
        foo(r + size/2, c + size/2, size/2);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        foo(0, N-1, N);

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<2*N; j++)
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
