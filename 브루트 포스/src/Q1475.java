/*
방 번호

https://www.acmicpc.net/problem/1475
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-22
 * Time: 오후 12:41
 */

public class Q1475
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[10];
        while(true)
        {
            ary[N%10]++;
            N /= 10;
            if(N == 0)
                break;
        }

        int max = 0;
        for(int i=0; i<10; i++)
        {
            if(i == 6 || i == 9)
                continue;

            max = Integer.max(max, ary[i]);
        }

        max = Integer.max(max, (ary[6] + ary[9] + 1) / 2);

        System.out.println(max);
    }
}
