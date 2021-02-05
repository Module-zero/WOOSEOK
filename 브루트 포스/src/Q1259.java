/*
팰린드롬수

https://www.acmicpc.net/problem/1259
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오후 5:31
 */

public class Q1259
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            String num = br.readLine();

            if(num.equals("0"))
                break;

            int si = 0;
            int ei = num.length() - 1;

            boolean isSame = true;
            while(si < ei)
            {
                char sch = num.charAt(si);
                char ech = num.charAt(ei);

                if(sch != ech)
                {
                    isSame = false;
                    break;
                }

                si++;
                ei--;
            }

            if(isSame)
                sb.append("yes\n");
            else
                sb.append("no\n");
        }

        System.out.print(sb.toString());
    }
}
