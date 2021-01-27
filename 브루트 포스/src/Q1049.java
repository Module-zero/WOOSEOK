/*
기타줄

https://www.acmicpc.net/problem/1049
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오전 2:58
 */

public class Q1049
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int minSix = Integer.MAX_VALUE;
        int minOne = Integer.MAX_VALUE;
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int six = Integer.parseInt(st.nextToken());
            minSix = Integer.min(minSix, six);
            int one = Integer.parseInt(st.nextToken());
            minOne = Integer.min(minOne, one);
        }

        if(minOne * 6 <= minSix)
            System.out.println(minOne * N);
        else
        {
            int rem = N % 6;
            if(rem != 0)
            {
                int cnt = (N + 5) / 6;
                int sum = Integer.min(minSix * cnt, minSix * (N / 6) + minOne * rem);
                System.out.println(sum);
            }
            else
                System.out.println(minSix * N / 6);
        }
    }
}
