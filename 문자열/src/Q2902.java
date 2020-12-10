/*
KMP는 왜 KMP일까?

https://www.acmicpc.net/problem/2902
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-10
 * Time: 오전 11:26
 */

public class Q2902
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuffer sb = new StringBuffer().append(str.charAt(0));
        boolean isFirst = false;
        for(int i=1; i<str.length(); i++)
        {
            if(isFirst)
            {
                sb.append(str.charAt(i));
                isFirst = false;
                continue;
            }

            if(str.charAt(i) == '-')
                isFirst = true;
        }

        System.out.println(sb.toString());
    }
}
