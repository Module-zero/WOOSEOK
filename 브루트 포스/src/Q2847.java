/*
게임을 만든 동준이

https://www.acmicpc.net/problem/2847
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 7:05
 */

public class Q2847
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] ary = new int[101];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(br.readLine());

        int cnt = 0;

        for(int i=N-2; i>=0; i--)
        {
            if(ary[i] >= ary[i+1])
            {
                int tmp = ary[i];
                ary[i] = ary[i+1] - 1;

                int diff = tmp - ary[i];
                cnt += diff;
            }
        }

        System.out.println(cnt);
    }
}
