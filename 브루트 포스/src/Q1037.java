/*
약수

https://www.acmicpc.net/problem/1037
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 11:39
 */

public class Q1037
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[51];
        ary[0] = 1;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(ary, 0, N+1);
        System.out.println(ary[N] * ary[1]);
    }
}
