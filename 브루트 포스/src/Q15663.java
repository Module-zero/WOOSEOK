/*
N과 M (9)

https://www.acmicpc.net/problem/15663
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-17
 * Time: 오전 12:10
 */

public class Q15663
{
    static int N;
    static int M;
    static int[] ary;
    static int[] tmp;
    static int[] cnt = new int[10001];
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int prevIndex)
    {
        if(index == M)
        {
        }

        for(int i=0; i<N; i++)
        {
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[N];
        tmp = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);

        int prev = 0;
        for(int i=0; i<N; i++)
            cnt[ary[i]] += 1;

        foo(0, -1);

        System.out.print(sb.toString());
    }
}
