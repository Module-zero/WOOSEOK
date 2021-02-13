/*
순서쌍의 곱의 합

https://www.acmicpc.net/problem/13900
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-13
 * Time: 오후 8:34
 */

public class Q13900
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ary = new int[100001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        long ans = 0;
        long sum = 0;
        for(int i=0; i<N; i++)
        {
            ans += sum * ary[i];
            sum += ary[i];
        }

        System.out.println(ans);
    }
}
