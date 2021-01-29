/*
극장 좌석

https://www.acmicpc.net/problem/2302
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오전 2:24
 */

public class Q2302
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] p = new int[41];
        p[0] = 1;
        p[1] = 1;
        for(int i=2; i<=40; i++)
            p[i] = p[i-1] + p[i-2];

        int M = Integer.parseInt(br.readLine());
        int cur = 1;
        int ans = 1;
        for(int i=0; i<M; i++)
        {
            int num = Integer.parseInt(br.readLine());
            int diff = num - cur;
            ans *= p[diff];
            cur = num + 1;
        }

        ans *= p[N - cur + 1];

        System.out.println(ans);
    }
}
