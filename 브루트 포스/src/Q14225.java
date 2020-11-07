/*
부분수열의 합

https://www.acmicpc.net/problem/14225
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 11:43
 */

public class Q14225
{
    static int N;
    static int[] ary = new int[21];
    static boolean[] check = new boolean[2000001];

    public static void foo(int n, int sum)
    {
        if(n == N)
        {
            check[sum] = true;
            return;
        }

        foo(n+1, sum+ary[n]);
        foo(n+1, sum);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        foo(0, 0);
        for(int i=1; ; i++)
        {
            if(!check[i])
            {
                System.out.println(i);
                return;
            }
        }
    }
}
