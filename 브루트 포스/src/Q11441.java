/*
합 구하기

https://www.acmicpc.net/problem/11441
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오전 12:15
 */

public class Q11441
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[100001];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] ps = new int[100001];
        for(int i=1; i<=N; i++)
            ps[i] = ps[i-1] + ary[i];

        StringBuffer sb = new StringBuffer();
        int M = Integer.parseInt(br.readLine());
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            sb.append(ps[e] - ps[s-1]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
