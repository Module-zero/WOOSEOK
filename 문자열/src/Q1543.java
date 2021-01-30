/*
문서 검색

https://www.acmicpc.net/problem/1543
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 10:42
 */

public class Q1543
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String target = br.readLine();
        String str = br.readLine();

        int[] fail = new int[51];
        int j = 0;
        int len = str.length();
        for(int i=1; i<len; i++)
        {
            while(j > 0 && str.charAt(j) != str.charAt(i))
                j = fail[j-1];

            if(str.charAt(j) == str.charAt(i))
                fail[i] = ++j;
        }

        j = 0;
        int tlen = target.length();
        int cnt = 0;
        for(int i=0; i<tlen; i++)
        {
            while(j > 0 && str.charAt(j) != target.charAt(i))
                j = fail[j-1];

            if(str.charAt(j) == target.charAt(i))
            {
                ++j;

                if(j == len)
                {
                    cnt++;
                    j = 0;
                }
            }
        }

        System.out.println(cnt);
    }
}
