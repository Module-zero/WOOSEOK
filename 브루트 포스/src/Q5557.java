/*
1학년

https://www.acmicpc.net/problem/5557
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-07
 * Time: 오후 4:27
 */

public class Q5557
{
    static int N;
    static int[] ary = new int[101];
    static boolean[] check = new boolean[101];
    static long ans = 0;

    public static void foo(int index, long sum)
    {
        if(sum < 0 || sum > 20)
            return;

        if(index == N)
        {
            ans++;
            return;
        }

        for(int i=0; i<N; i++)
        {
            if(check[i])
                continue;

            check[i] = true;
            foo(index+1, sum+ary[i]);
            foo(index+1, sum-ary[i]);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        check[0] = true;
        foo(1, ary[0]);

        System.out.println(ans);
    }
}
