/*
동전 1

https://www.acmicpc.net/problem/2293
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오전 2:53
 */

public class Q2293
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] token = new int[101];
        for(int i=0; i<n; i++)
            token[i] = Integer.parseInt(br.readLine());

        Arrays.sort(token, 0, n);
        int[] ary = new int[100001];
        for(int i=0; i<n; i++)
        {
            ary[token[i]]++;

            for(int j=token[i]; j<=k; j++)
                ary[j] = ary[j] + ary[j-token[i]];
        }

        System.out.println(ary[k]);
    }
}
