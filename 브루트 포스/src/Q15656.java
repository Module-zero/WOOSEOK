/*
N과 M (7)

https://www.acmicpc.net/problem/15656
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
 * Time: 오후 11:54
 */

public class Q15656
{
    static int N;
    static int M;
    static int[] ary;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int[] ans)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                sb.append(ans[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=0; i<N; i++)
        {
            ans[index] = ary[i];
            foo(index+1, ans);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary);

        foo(0, new int[M]);
        System.out.print(sb.toString());
    }
}
