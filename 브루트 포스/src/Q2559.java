/*
수열

https://www.acmicpc.net/problem/2559
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 8:42
 */

public class Q2559
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[100001];
        int[] ps = new int[100001];
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(st.nextToken());

            if(i == 0)
                ps[i] = ary[i];
            else
                ps[i] = ps[i-1] + ary[i];

            if(i >= K-1)
            {
                if(i >= K)
                    ps[i] -= ary[i-K];

                max = Integer.max(max, ps[i]);
            }
        }

        System.out.println(max);
    }
}
