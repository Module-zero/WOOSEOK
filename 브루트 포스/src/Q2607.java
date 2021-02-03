/*
비슷한 단어

https://www.acmicpc.net/problem/2607
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 3:40
 */

public class Q2607
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] cnt = new int[26];
        int N = Integer.parseInt(br.readLine());
        String str = br.readLine();
        int len = str.length();
        for(int i=0; i<len; i++)
        {
            int num = str.charAt(i) - 'A';
            cnt[num]++;
        }

        int ans = 0;
        for(int i=0; i<N-1; i++)
        {
            String tmp = br.readLine();

            int[] tcnt = new int[26];
            int tlen = tmp.length();
            int dlen = Math.abs(len - tlen);
            if(dlen > 1)
                continue;

            for(int j=0; j<tlen; j++)
            {
                int num = tmp.charAt(j) - 'A';
                tcnt[num]++;
            }

            int dcnt = 0;
            boolean isContinue = false;
            for(int j=0; j<26; j++)
            {
                int diff = Math.abs(cnt[j] - tcnt[j]);

                if(diff >= 2)
                {
                    isContinue = true;
                    break;
                }

                dcnt += diff;
            }

            if(isContinue)
                continue;

            if(dcnt >= 3)
                continue;

            ans++;
        }

        System.out.println(ans);
    }
}
