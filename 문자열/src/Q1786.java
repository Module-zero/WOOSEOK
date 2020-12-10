/*
찾기

https://www.acmicpc.net/problem/1786
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-10
 * Time: 오후 3:35
 */

public class Q1786
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String T = br.readLine();
        String P = br.readLine();
        int n = T.length();
        int m = P.length();

        int[] fail = new int[1000001];
        int j = 0;
        for(int i=1; i<m; i++)
        {
            while(j > 0 && P.charAt(i) != P.charAt(j))
                j = fail[j-1];

            if(P.charAt(i) == P.charAt(j))
                fail[i] = ++j;
        }

        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        j = 0;
        for(int i=0; i<n; i++)
        {
            while(j>0 && T.charAt(i) != P.charAt(j))
                j = fail[j-1];

            if(T.charAt(i) == P.charAt(j))
            {
                if(j == m-1)
                {
                    sb.append(i-m+2);
                    j = fail[j];
                    cnt++;
                }
                else
                    j++;
            }
        }

        System.out.println(cnt);
        System.out.println(sb.toString());
    }
}
