/*
주몽

https://www.acmicpc.net/problem/1940
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오전 1:17
 */

public class Q1940
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] ary = new int[15001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        for(int i=0; i<N-1; i++)
        {
            for(int j=i+1; j<N; j++)
            {
                int sum = ary[i] + ary[j];

                if(sum == M)
                    cnt++;
            }
        }

        System.out.println(cnt);
    }
}
