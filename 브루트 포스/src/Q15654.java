/*
N과 M (5)

https://www.acmicpc.net/problem/15654
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-16
 * Time: 오후 11:04
 */

public class Q15654
{
    static int N;
    static int M;
    static int[] ary;
    static int[] ans;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
            {
                sb.append(ans[i] + " ");
            }

            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++)
        {
            if(check[i])
                continue;

            ans[index] = ary[i];
            check[i] = true;
            foo(index+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        check = new boolean[N];
        ary = new int[N];
        ans = new int[M];
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);
        foo(0);
        System.out.print(sb.toString());
    }
}
