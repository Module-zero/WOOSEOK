/*
검문

https://www.acmicpc.net/problem/2981
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 12:47
 */

public class Q2981
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        int[] ary = new int[101];
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            max = Integer.max(max, ary[i]);
            min = Integer.min(min, ary[i]);
        }

        int cnt = 0;
        for(int num=min; num>0; num--)
        {

        }
    }
}
