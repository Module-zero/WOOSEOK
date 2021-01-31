/*
팰린드롬 만들기

https://www.acmicpc.net/problem/1213
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 7:48
 */

public class Q1213
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] ary = new int[26];
        int len = str.length();
        for(int i=0; i<len; i++)
        {
            int id = str.charAt(i) - 'A';
            ary[id]++;
        }

        int cnt = 0;
        int ref = -1;
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<26; i++)
        {
            if(ary[i] % 2 == 1)
            {
                if(cnt == 1)
                {
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }
                else
                {
                    cnt++;
                    ref = i;
                }
            }

            if(ary[i] != 0)
            {
                char ch = (char)('A' + i);

                for(int j=0; j<ary[i]/2; j++)
                    sb.append(ch);
            }
        }

        StringBuffer ans = new StringBuffer().append(sb.toString());
        if(ref != -1)
            ans.append((char)('A' + ref));

        ans.append(sb.reverse().toString());
        System.out.println(ans.toString());
    }
}
