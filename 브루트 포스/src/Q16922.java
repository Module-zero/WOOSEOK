/*
로마 숫자 만들기

https://www.acmicpc.net/problem/16922
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-11
 * Time: 오후 3:26
 */

public class Q16922
{
    static int N;
    static boolean[] check = new boolean[50*20 + 1];
    static int[] ary = {1, 5, 10, 50};
    static int test = 0;

    public static void foo(int n, int sum, int prev)
    {
        if(n == N)
        {
            System.out.println(sum);
            check[sum] = true;
            return;
        }

        for(int i=prev; i<4; i++)
            foo(n+1, sum+ary[i], i);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        foo(0, 0, 0);

        int cnt = 0;
        for(int i=1; i<=50*N; i++)
        {
            if(check[i])
                cnt++;
        }

        System.out.println(cnt);
    }
}
