/*
부분 문자열

https://www.acmicpc.net/problem/16916
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-10
 * Time: 오전 10:49
 */

public class Q16916
{
    static long prime = Integer.MAX_VALUE;
    static int num = 256;

    public static long hash(String str)
    {
        long ret = 0;
        int len = str.length();
        for(int i=0; i<len; i++)
            ret = (ret * num + str.charAt(i)) % prime;

        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String P = br.readLine();

        int sLen = S.length();
        int pLen = P.length();
        if(sLen < pLen)
        {
            System.out.println(0);
            return;
        }

        long pHash = hash(P);
        long sHash = hash(S.substring(0, pLen));
        long first = 1;
        for(int i=0; i<pLen-1; i++)
            first = (first * num) % prime;

        for(int i=0; i<=sLen - pLen; i++)
        {
            if(pHash == sHash)
            {
                System.out.println(1);
                return;
            }

            if(i+pLen < sLen)
            {
                sHash = sHash - (S.charAt(i) * first) % prime;
                // 음수 방지
                sHash = (sHash + prime) % prime;
                sHash = ((sHash * num) % prime + S.charAt(i+pLen)) % prime;
            }
        }

        System.out.println(0);
    }
}
