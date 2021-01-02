/*
나는 친구가 적다 (Large)

https://www.acmicpc.net/problem/16172
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-26
 * Time: 오후 9:41
 */

public class Q16172
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();
        String K = br.readLine();

        int kLen = K.length();
        int[] fail = new int[200001];
        int j = 0;
        for(int i=1; i<kLen; i++)
        {
            while(j>0 && K.charAt(i) != K.charAt(j))
                j = fail[j-1];

            if(K.charAt(i) == K.charAt(j))
                fail[i] = ++j;
        }

        int sLen = S.length();
        j = 0;
        for(int i=0; i<sLen; i++)
        {
            if(S.charAt(i) <= '9')
                continue;

            while(j>0 && S.charAt(i) != K.charAt(j))
                j = fail[j-1];

            if(S.charAt(i) == K.charAt(j))
            {
                j++;
                if(j == kLen)
                {
                    System.out.println(1);
                    return;
                }
            }
        }

        System.out.println(0);
    }
}
