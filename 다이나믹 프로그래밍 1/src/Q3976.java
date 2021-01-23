/*
역습

https://www.acmicpc.net/problem/3976
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 10:36
 */

public class Q3976
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int c = Integer.parseInt(br.readLine());
        while(c-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int l1 = Integer.parseInt(st.nextToken());
            int l2 = Integer.parseInt(st.nextToken());
            int s1 = Integer.parseInt(st.nextToken());
            int s2 = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] aPass = new int[100001];
            for(int i=0; i<n-1; i++)
                aPass[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] aDribble = new int[100001];
            for(int i=0; i<n-1; i++)
                aDribble[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] bPass = new int[100001];
            for(int i=0; i<n-1; i++)
                bPass[i] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            int[] bDribble = new int[100001];
            for(int i=0; i<n-1; i++)
                bDribble[i] = Integer.parseInt(st.nextToken());

            int[][] d = new int[2][100001];
            d[0][0] = l1;
            d[1][0] = l2;

            for(int i=1; i<n; i++)
            {
                d[0][i] = Integer.min(d[0][i-1] + aDribble[i-1], d[1][i-1] + bPass[i-1]);
                d[1][i] = Integer.min(d[1][i-1] + bDribble[i-1], d[0][i-1] + aPass[i-1]);
            }

            sb.append(Integer.min(d[0][n-1] + s1, d[1][n-1] + s2)).append('\n');
        }

        System.out.print(sb.toString());
    }
}
