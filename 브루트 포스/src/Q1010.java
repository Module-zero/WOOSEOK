/*
다리 놓기

https://www.acmicpc.net/problem/1010
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 12:01
 */

public class Q1010
{
    public static long foo(int n, int lim)
    {
        if(n == lim)
            return 1;

        long sum = n;

        for(int i=n-1; i>lim; i--)
            sum *= i;

        return sum;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int max = Integer.max(N, M);
            int min = Integer.min(N, M);
            int minMax = Integer.max(max - min, min);
            int minMin = Integer.min(max - min, min);

            long ans = foo(max, minMax) / foo(minMin, 0);
            sb.append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
