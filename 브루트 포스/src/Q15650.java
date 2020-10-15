/*
N과 M (2)

https://www.acmicpc.net/problem/15650
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-15
 * Time: 오후 5:55
 */

public class Q15650
{
    static int N;
    static int M;
    static int[] ary;
    static StringBuilder sb;

    public static void per(int index, int start)
    {
        if(index == M)
        {
            for(int i=0; i<index; i++)
            {
                sb.append(ary[i] + " ");
            }

            sb.append('\n');
            return;
        }

        for(int i=start; i<=N; i++)
        {
            ary[index] = i;
            per(index + 1, i+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new int[M];
        sb = new StringBuilder();

        per(0, 1);

        System.out.print(sb.toString());
    }
}
