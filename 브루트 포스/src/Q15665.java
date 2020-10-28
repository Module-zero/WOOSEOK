/*
N과 M (11)

https://www.acmicpc.net/problem/15665
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-27
 * Time: 오후 8:42
 */

public class Q15665
{
    static int N;
    static int M;
    static int[] ary;
    static int[] tmp;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index)
    {
        if(index == M)
        {
            for(int i=0; i<M; i++)
                sb.append(tmp[i]).append(" ");

            sb.append("\n");
            return;
        }

        int prev = -1;
        for(int i=0; i<N; i++)
        {
            if(ary[i] != prev)
            {
                prev = ary[i];
                tmp[index] = ary[i];
                foo(index+1);
            }
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

        foo(0);

        System.out.print(sb.toString());
    }
}
