/*
공유기 설치

https://www.acmicpc.net/problem/2805
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 4:59
 */

public class Q2110
{
    static int N;
    static int C;
    static int[] ary = new int[200001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<N; i++)
        {
            ary[i] = Integer.parseInt(br.readLine());
            if(ary[i] < min)
                min = ary[i];
            if(ary[i] > max)
                max = ary[i];
        }


    }
}
