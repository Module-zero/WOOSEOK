/*
팰린드롬 만들기

https://www.acmicpc.net/problem/1254
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-14
 * Time: 오후 8:06
 */

public class Q1254
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();
        String rs = new StringBuffer().append(s).reverse().toString();

        int len = s.length();
        int max = 0;
        for(int i=0; i<len; i++)
        {
            int cnt = 0;

            int j = i;
            for(; j<len; j++)
            {
                if(s.charAt(j) == rs.charAt(j-i))
                    cnt++;
                else
                    break;
            }

            if(j == len && cnt > max)
                max = cnt;
        }

        System.out.println(len + len - max);
    }
}
