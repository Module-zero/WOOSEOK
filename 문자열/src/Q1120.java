/*
문자열

https://www.acmicpc.net/problem/1120
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 9:48
 */

public class Q1120
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        String a = st.nextToken();
        String b = st.nextToken();

        if(a.length() > b.length())
        {
            String tmp = a;
            a = b;
            b = tmp;
        }

        int aLen = a.length();
        int bLen = b.length();
        int min = Integer.MAX_VALUE;
        for(int i=0; i<=bLen - aLen; i++)
        {
            int cnt = 0;
            for(int j=0; j<aLen; j++)
            {
                if(b.charAt(i+j) != a.charAt(j))
                    cnt++;
            }

            min = Integer.min(cnt, min);
        }

        System.out.println(min);
    }
}
