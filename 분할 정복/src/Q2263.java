/*
트리의 순회

https://www.acmicpc.net/problem/2263
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-05
 * Time: 오후 3:58
 */

public class Q2263
{
    static int[] in = new int[100001];
    static int[] post = new int[100001];
    static StringBuilder sb = new StringBuilder();

    public static void foo(int in_start, int in_end, int post_start, int post_end)
    {
        System.out.print(post[post_end] + " ");
        if(in_start == in_end && post_start == post_end)
            return;

        int in_mid = (in_start + in_end) / 2;
        int post_mid = (post_start + post_end) / 2;

        foo(in_start, in_mid - 1, post_start, );
        foo(in_mid + 1, in_end, , post_end - 1)
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            in[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            post[i] = Integer.parseInt(st.nextToken());

        foo(0, n-1, 0, n-1);
    }
}
