/*
A와 B

https://www.acmicpc.net/problem/12904
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 11:04
 */

public class Q12904
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String T = br.readLine();

        int lenS = S.length();
        int lenT = T.length();

        StringBuilder sb = new StringBuilder(T);
        while(lenT > lenS)
        {
            lenT--;

            if(sb.charAt(lenT) == 'A')
                sb.delete(lenT, lenT+1);
            else
            {
                sb.delete(lenT, lenT+1);
                sb.reverse();
            }

            if(sb.toString().equals(S))
            {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }
}
