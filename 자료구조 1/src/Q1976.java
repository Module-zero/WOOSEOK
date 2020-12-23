/*
여행 가자

https://www.acmicpc.net/problem/1976
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-21
 * Time: 오후 7:21
 */

public class Q1976
{
    static int N;
    static int M;
    static int[][] ary = new int[201][201];
    static int[] p = new int[201];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;
        p[n] = find(p[n]);
        return p[n];
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(a == b)
            return;
        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
            p[i] = -1;

        for(int i=1; i<=N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] == 1)
                    merge(i, j);
            }
        }

        int[] dest = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<M; i++)
            dest[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<M-1; i++)
        {
            if(find(dest[i]) != find(dest[i+1]))
            {
                System.out.println("NO");
                return;
            }
        }

        System.out.println("YES");
    }
}