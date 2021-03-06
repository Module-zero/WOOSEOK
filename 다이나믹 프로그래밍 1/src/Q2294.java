/*
동전 2

https://www.acmicpc.net/problem/2294
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 5:46
 */

public class Q2294
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
        int[] ary = new int[10001];
        for(int i=1; i<=k; i++)
            ary[i] = 20000;

        for(int i=0; i<n; i++)
        {
            int start = token[i];

            for(int s=start; s<=k; s++)
                ary[s] = Integer.min(ary[s - start] + 1, ary[s]);
        }

        System.out.println(ary[k] == 20000 ? -1 : ary[k]);
    }
}
