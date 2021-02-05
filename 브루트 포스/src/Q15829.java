/*
Hashing

https://www.acmicpc.net/problem/15829
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-05
 * Time: 오후 10:21
 */

public class Q15829
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int L = Integer.parseInt(br.readLine());
        String str = br.readLine();

        int len = str.length();
        long r = 1;
        long tr = 31;
        long M = 1234567891;
        long ans = 0;

        for(int i=0; i<len; i++)
        {
            int num = str.charAt(i) - 'a' + 1;

            ans = (ans + num * r) % M;

            r = (r * tr) % M;
        }

        System.out.println(ans);
    }
}
