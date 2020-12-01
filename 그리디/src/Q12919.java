/*
A와 B 2

https://www.acmicpc.net/problem/12919
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-26
 * Time: 오전 12:00
 */

public class Q12919
{
    static String S;
    static int lenS;
    static boolean ans = false;

    public static void foo(StringBuilder sb, int lenT)
    {
        if(lenT == lenS)
        {
            if(sb.toString().equals(S))
                ans = true;

            return;
        }

        // 둘 다 가능
        if(sb.charAt(lenT-1) == 'A' && sb.charAt(0) == 'B')
        {
            StringBuilder tmp = new StringBuilder(sb);
            tmp.delete(lenT-1, lenT);
            foo(tmp, lenT-1);

            sb.delete(0, 1);
            sb.reverse();
            foo(sb, lenT-1);
        }
        else if(sb.charAt(lenT-1) == 'A')
        {
            sb.delete(lenT-1, lenT);
            foo(sb, lenT-1);
        }
        else if(sb.charAt(0) == 'B')
        {
            sb.delete(0, 1);
            sb.reverse();
            foo(sb, lenT-1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();
        String T = br.readLine();

        lenS = S.length();
        int lenT = T.length();

        foo(new StringBuilder(T), lenT);

        if(ans)
            System.out.println(1);
        else
            System.out.println(0);
    }
}
