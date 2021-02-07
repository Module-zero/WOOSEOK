/*
수열

https://www.acmicpc.net/problem/2491
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-07
 * Time: 오전 1:02
 */

public class Q2491
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[100001];
        int[] up = new int[100001];
        int[] down = new int[100001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int max = 1;
        up[0] = 1;
        down[0] = 1;
        for(int i=1; i<N; i++)
        {
            if(ary[i-1] <= ary[i])
                up[i] = up[i-1] + 1;
            else
                up[i] = 1;

            if(ary[i-1] >= ary[i])
                down[i] = down[i-1] + 1;
            else
                down[i] = 1;

            max = Integer.max(max, up[i]);
            max = Integer.max(max, down[i]);
        }

        System.out.println(max);
    }
}
