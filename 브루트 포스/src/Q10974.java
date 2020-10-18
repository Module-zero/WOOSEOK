/*
모든 순열

https://www.acmicpc.net/problem/10974
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 7:26
 */

public class Q10974
{
    static int N;
    static int[] ary;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index)
    {
        if(index == N)
        {
            for(int i=0; i<N; i++)
                sb.append(ary[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++)
        {
            if(check[i+1])
                continue;

            ary[index] = i+1;
            check[i+1] = true;
            foo(index+1);
            check[i+1] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        ary = new int[N];
        check = new boolean[N+1];

        foo(0);

        System.out.println(sb.toString());
    }
}
