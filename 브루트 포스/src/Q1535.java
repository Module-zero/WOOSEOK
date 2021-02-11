/*
안녕

https://www.acmicpc.net/problem/1535
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-11
 * Time: 오후 8:15
 */

public class Q1535
{
    static int N;
    static int[] L = new int[21];
    static int[] J = new int[21];
    static int max = 0;

    public static void foo(int index, int life, int sum)
    {
        if(life <= 0)
            return;

        if(index == N)
        {
            max = Integer.max(max, sum);
            return;
        }

        foo(index+1, life-L[index], sum+J[index]);
        foo(index+1, life, sum);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            L[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            J[i] = Integer.parseInt(st.nextToken());

        foo(0, 100, 0);

        System.out.println(max);
    }
}
