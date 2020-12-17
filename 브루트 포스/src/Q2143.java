/*
두 배열의 합

https://www.acmicpc.net/problem/2143
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-16
 * Time: 오후 5:18
 */

public class Q2143
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] ary1 = new int[1001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++)
            ary1[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] ary2 = new int[1001];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<m; i++)
            ary2[i] = Integer.parseInt(st.nextToken());
    }
}
