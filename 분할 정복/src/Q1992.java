/*
쿼드트리

https://www.acmicpc.net/problem/1992
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 4:40
 */

public class Q1992
{
    static int N;
    static char[][] ary = new char[64][64];
    static StringBuffer sb = new StringBuffer();

    public static void foo(int left, int up, int size)
    {
        boolean ok = true;

        char ch = ary[up][left];

        for(int i=up; i<up+size; i++)
        {
            for(int j=left; j<left+size; j++)
            {
                if(ary[i][j] != ch)
                {
                    ok = false;
                    break;
                }
            }

            if(!ok)
                break;
        }

        if(!ok)
        {
            sb.append('(');

            size /= 2;
            foo(left, up, size);
            foo(left+size, up, size);
            foo(left, up+size, size);
            foo(left+size, up+size, size);

            sb.append(')');
        }
        else
            sb.append(ch);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j);
        }

        foo(0, 0, N);

        System.out.println(sb.toString());
    }
}
