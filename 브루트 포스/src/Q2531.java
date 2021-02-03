/*
회전 초밥

https://www.acmicpc.net/problem/2531
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 10:48
 */

public class Q2531
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] ary = new int[30001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        int max = 1;
        int si = 0;
        int ei = 1;
        while(si < N)
        {
            if(ary[si] != ary[ei])
            {
                ei = (ei + 1) % N;

                if(ei < si)
                {
                    int cnt = N - si + ei;

                }
                else
                {
                    int cnt = ei - si;
                }
            }
            else
            {

            }
        }
    }
}
