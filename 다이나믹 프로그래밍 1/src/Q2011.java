/*
암호코드

https://www.acmicpc.net/problem/2011
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 11:52
 */

public class Q2011
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int[] d = new int[5001];
        d[0] = 1;
        d[1] = 1;
        for(int i=1; i<=len; i++)
        {
            char ch = str.charAt(i-1);
            if(i == 1)
            {
                if(ch == '0')
                {
                    System.out.println(0);
                    return;
                }
                else
                    continue;
            }

            char prev = str.charAt(i-2);

            if(prev == '1')
            {
                d[i] = d[i-2] % 1000000;

                if(ch == '0')
                    continue;
            }
            else if(prev == '2')
            {
                if(ch <= '6')
                    d[i] = d[i-2] % 1000000;

                if(ch == '0')
                    continue;
            }
            else
            {
                if(ch == '0')
                {
                    System.out.println(0);
                    return;
                }
            }

            d[i] = (d[i] + d[i-1]) % 1000000;
        }

        System.out.println(d[len]);
    }
}
