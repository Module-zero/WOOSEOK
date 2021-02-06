/*
제곱 ㄴㄴ 수

https://www.acmicpc.net/problem/1016
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-06
 * Time: 오후 9:14
 */

public class Q1016
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] ary = new long[1000002];
        for(int i=1; i<=1000001; i++)
            ary[i] = (long)i * i;

        StringTokenizer st = new StringTokenizer(br.readLine());
        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());

        int si = 2;
        int ei = 1;
        while(min >= ary[si+1])
        {
            ++si;
            ++ei;
        }

        while(max >= ary[ei+1])
            ++ei;

        long cnt = max - min + 1;

        System.out.println(cnt);
    }
}
