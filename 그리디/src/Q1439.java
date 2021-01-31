/*
뒤집기

https://www.acmicpc.net/problem/1439
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오전 12:17
 */

public class Q1439
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int zero = 0;
        int one = 0;

        int len = str.length();
        if(str.charAt(0) == '1')
            one++;
        else
            zero++;

        for(int i=1; i<len; i++)
        {
            char ch = str.charAt(i);

            if(ch != str.charAt(i-1))
            {
                if(ch == '1')
                    one++;
                else
                    zero++;
            }
        }

        System.out.println(Integer.min(zero, one));
    }
}
