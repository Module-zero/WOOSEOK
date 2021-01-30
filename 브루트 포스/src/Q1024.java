/*
수열의 합

https://www.acmicpc.net/problem/1024
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 9:57
 */

public class Q1024
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int sum = 0;
        int left = 0;
        int right = 0;
        int lim = (N + 3) / 2;
        for(int i=1; i<=lim; i++)
        {
            if(sum <= N)
            {
                sum += i;
                right = i;

                if(sum == N)
                {

                }
            }
            else
            {
                while(sum > N)
                {
                    sum -= left;
                    left = left + 1;
                }

                if(sum == N)
                {

                }
            }
        }

        if(right - left + 1 > 100)
            System.out.println(-1);
        else
        {

        }
    }
}
