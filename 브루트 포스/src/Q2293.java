/*
동전 1

https://www.acmicpc.net/problem/2293
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 12:49
 */

public class Q2293
{
    static int n;
    static int k;
    static int[][] ary = new int[100][10001];
    static int cnt = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for(int i=0; i<n; i++)
            ary[i][1] = Integer.parseInt(br.readLine());

        for(int i=0; i<n; i++)
        {
            for(int j=2; j<k; j++)
                ary[i][j] = ary[i][j-1] + ary[i][1];
        }


    }
}
