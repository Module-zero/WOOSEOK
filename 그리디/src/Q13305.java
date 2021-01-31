/*
주유소

https://www.acmicpc.net/problem/13305
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-30
 * Time: 오후 11:24
 */

public class Q13305
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] dist = new int[100001];
        for(int i=0; i<N-1; i++)
            dist[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] oil = new int[100001];
        for(int i=0; i<N; i++)
            oil[i] = Integer.parseInt(st.nextToken());

        long sum = 0;
        int price = Integer.MAX_VALUE;
        for(int i=0; i<N; i++)
        {
            price = Integer.min(price, oil[i]);

            sum += (long)price * dist[i];
        }

        System.out.println(sum);
    }
}
