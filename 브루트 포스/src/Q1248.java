/*
맞춰봐

https://www.acmicpc.net/problem/1248
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-25
 * Time: 오후 8:59
 */

public class Q1248
{
    static int N;
    static char[][] ary = new char[21][21];

    public static void foo(int id1, int id2)
    {
        for(int n=-10; n<=10; n++)
        {
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int k = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=i; j<N; j++)
            {
                ary[i][j] = str.charAt(k);
                k++;
            }
        }


    }
}
