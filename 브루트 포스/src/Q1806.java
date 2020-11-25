/*
부분합

https://www.acmicpc.net/problem/1806
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 9:22
 */

public class Q1806
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] ary = new int[100001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int min = Integer.MAX_VALUE;
        int lId = 0;
        int rId = 0;
        int sum = ary[0];
        while(rId < N)
        {
            if(sum >= S)
            {
                int len = rId - lId + 1;
                if(len < min)
                    min = len;

                sum -= ary[lId++];
            }
            else
                sum += ary[++rId];
        }

        if(min == Integer.MAX_VALUE)
            min = 0;

        System.out.println(min);
    }
}
