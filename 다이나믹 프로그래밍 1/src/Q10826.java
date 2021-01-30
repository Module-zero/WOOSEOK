/*
피보나치 수 4

https://www.acmicpc.net/problem/10826
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 11:16
 */

public class Q10826
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String[] ary = new String[10001];
        ary[0] = "0";
        ary[1] = "1";

        for(int i=2; i<=n; i++)
        {
            int aLen = ary[i-1].length();
            int bLen = ary[i-2].length();
            int len = Integer.min(aLen, bLen);
            int next = 0;
            int adiff = 0;
            int bdiff = 0;
            if(aLen > bLen)
                adiff = aLen - bLen;
            else
                bdiff = bLen - aLen;

            StringBuffer sb = new StringBuffer();
            for(int k=len-1; k>=0; k--)
            {
                int ach = ary[i-1].charAt(k + adiff) - '0';
                int bch = ary[i-2].charAt(k + bdiff) - '0';

                int sum = ach + bch + next;
                int rem = sum % 10;
                next = sum / 10;
                sb.append(rem);
            }

            while(adiff > 0)
            {
                int sum = ary[i-1].charAt(adiff-1) - '0' + next;
                int rem = sum % 10;

                sb.append(rem);

                next = sum / 10;
                adiff--;
            }

            while(bdiff > 0)
            {
                int sum = ary[i-2].charAt(bdiff-1) - '0' + next;
                int rem = sum % 10;

                sb.append(rem);

                next = sum / 10;
                bdiff--;
            }

            if(next != 0)
                sb.append(next);

            ary[i] = sb.reverse().toString();
        }

        System.out.println(ary[n]);
    }
}
