/*
구슬 탈출 2

https://www.acmicpc.net/problem/13460
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 12:53
 */

public class Q13460
{
    static int N;
    static int M;
    static char[][] ary = new char[11][11];
    static int max = -1;

    public static void foo(int index)
    {

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }
    }
}
