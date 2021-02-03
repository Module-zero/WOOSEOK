/*
IOIOI

https://www.acmicpc.net/problem/5525
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 9:44
 */

public class Q5525
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        StringBuffer sb = new StringBuffer();
        sb.append('I');
        for(int i=0; i<N; i++)
            sb.append("OI");

        String str = sb.toString();
        int j = 0;
        int len = str.length();
        int[] fail = new int[2000001];
        for(int i=1; i<len; i++)
        {
            while(j > 0 && str.charAt(i) != str.charAt(j))
                j = fail[j-1];

            if(str.charAt(i) == str.charAt(j))
                fail[i] = ++j;
        }

        j = 0;
        int cnt = 0;
        for(int i=0; i<M; i++)
        {
            while(j > 0 && str.charAt(j) != S.charAt(i))
                j = fail[j-1];

            if(str.charAt(j) == S.charAt(i))
            {
                ++j;
                if(j == len)
                {
                    cnt++;
                    j = fail[len-1];
                }
            }
        }

        System.out.println(cnt);
    }
}
