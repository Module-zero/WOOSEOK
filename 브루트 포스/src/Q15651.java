/*
N과 M (3)

https://www.acmicpc.net/problem/15651
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-16
 * Time: 오후 9:36
 */

public class Q15651
{
    static int N;
    static int M;
    static int[] ary;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                sb.append(ary[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=1; i<=N; i++)
        {
            ary[index] = i;
            foo(index+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[M];

        foo(0);
        System.out.println(sb.toString());
    }
}
