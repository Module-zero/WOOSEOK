/*
별 찍기 - 19

https://www.acmicpc.net/problem/10994
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오전 1:10
 */

public class Q10994
{
    static char[][] ary = new char[4000][4000];

    public static void foo(int N, int up, int left)
    {
        if(N == 0)
            return;

        int lim = 4*(N-1);
        for(int i=left; i<=left+lim; i++)
        {
            ary[up][i] = '*';
            ary[up+lim][i] = '*';
        }

        for(int i=up+1; i<=up+lim; i++)
        {
            ary[i][left] = '*';
            ary[i][left+lim] = '*';
        }

        foo(N-1, up+2, left+2);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int lim = 4*(N-1);
        foo(N, 0, 0);
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<=lim; i++)
        {
            for(int j=0; j<=lim; j++)
                sb.append((ary[i][j] == 0 ? ' ' : ary[i][j]));

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
