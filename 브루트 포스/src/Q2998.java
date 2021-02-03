/*
8진수

https://www.acmicpc.net/problem/2998
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오전 1:19
 */

public class Q2998
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        int ei = len;
        int si = Integer.max(0, ei-3);
        StringBuffer sb = new StringBuffer();
        while(ei > 0)
        {
            int num = Integer.parseInt(str.substring(si, ei));

            switch(num)
            {
                case 0:
                    sb.append(0);
                    break;
                case 1:
                    sb.append(1);
                    break;
                case 10:
                    sb.append(2);
                    break;
                case 11:
                    sb.append(3);
                    break;
                case 100:
                    sb.append(4);
                    break;
                case 101:
                    sb.append(5);
                    break;
                case 110:
                    sb.append(6);
                    break;
                case 111:
                    sb.append(7);
                    break;
            }

            ei = si;
            si = Integer.max(0, ei-3);
        }

        System.out.println(sb.reverse().toString());
    }
}
