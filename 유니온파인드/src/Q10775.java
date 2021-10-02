/*
공항

https://www.acmicpc.net/problem/10775
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-28
 * Time: 오전 1:40
 */

public class Q10775
{
    static int[] p = new int[100001];

    static int find(int n)
    {
        if(p[n] < 0)
            return n;

        return p[n] = find(p[n]);
    }

    static void merge(int a, int b)
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

        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        for(int i=0; i<=G; i++)
            p[i] = -1;

        int cnt = 0;
        while(P-- > 0)
        {
            int n = Integer.parseInt(br.readLine());

            int f = find(n);
            if(f == 0)
                break;

            merge(f-1, f);
            cnt++;
        }

        System.out.println(cnt);
    }
}
