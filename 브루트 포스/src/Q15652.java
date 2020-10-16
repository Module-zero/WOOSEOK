/*
N과 M (4)

https://www.acmicpc.net/problem/15652
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-16
 * Time: 오후 9:46
 */

public class Q15652
{
    static int N;
    static int M;
    static int[] ary;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int start)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                sb.append(ary[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=start; i<=N; i++)
        {
            ary[index] = i;
            foo(index+1, i);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[M];

        foo(0, 1);
        System.out.println(sb.toString());
    }
}
