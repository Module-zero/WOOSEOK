/*
반지

https://www.acmicpc.net/problem/5555
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-29
 * Time: 오후 8:09
 */

public class Q5555
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int N = Integer.parseInt(br.readLine());
        int[] fail = new int[11];
        int j = 0;
        int len = str.length();
        for(int i=1; i<len; i++)
        {
            while(j > 0 && str.charAt(i) != str.charAt(j))
                j = fail[j];

            if(str.charAt(i) == str.charAt(j))
                fail[i] = ++j;
        }

        int ans = 0;
        for(int i=0; i<N; i++)
        {
            String tmp = br.readLine();
            int tLen = tmp.length();

            for(int sId=0; sId<tLen; sId++)
            {
                j = 0;
                boolean found = false;
                for(int cnt=0; cnt<tLen; cnt++)
                {
                    int id = (sId + cnt) % tLen;
                    if (j > 0 && tmp.charAt(id) != str.charAt(j))
                        j = fail[j];

                    if(tmp.charAt(id) == str.charAt(j))
                    {
                        ++j;

                        if(j == len)
                        {
                            ans++;
                            found = true;
                            break;
                        }
                    }
                }

                if(found)
                    break;
            }
        }

        System.out.println(ans);
    }
}
