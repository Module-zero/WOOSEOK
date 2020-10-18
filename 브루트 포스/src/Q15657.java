/*
N과 M (8)

https://www.acmicpc.net/problem/15657
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-17
 * Time: 오전 12:01
 */

public class Q15657
{
    static int N;
    static int M;
    static int[] ary;
    static int[] ans;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int start)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                sb.append(ans[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=start; i<N; i++)
        {
            ans[index] = ary[i];
            foo(index+1, i);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[N];
        ans = new int[M];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);

        foo(0, 0);
        System.out.println(sb.toString());
    }
}
