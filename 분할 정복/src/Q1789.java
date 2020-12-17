/*
수들의 합

https://www.acmicpc.net/problem/1789
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 4:00
 */

public class Q1789
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long S = Long.parseLong(br.readLine());

        int left = 0;
        int right = 100000;

        int ans = 0;
        while(left <= right)
        {
            int mid = (left + right) / 2;

            long sum = (long)mid * (mid+1) / 2;

            if(sum <= S)
            {
                ans = mid;
                left = mid + 1;
            }
            else
                right = mid - 1;
        }

        System.out.println(ans);
    }
}
