/*
베스트셀러

https://www.acmicpc.net/problem/1302
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 8:58
 */

public class Q1302
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        TreeMap<String, Integer> map = new TreeMap<>();
        String maxStr = null;
        int max = 0;
        while(N-- > 0)
        {
            String str = br.readLine();
            Integer it = map.get(str);
            if(it == null)
            {
                map.put(str, 1);
                if(max <= 1)
                {
                    if(maxStr == null)
                    {
                        maxStr = str;
                        max = 1;
                    }
                    else
                    {
                        if(maxStr.compareTo(str) > 0)
                            maxStr = str;
                    }
                }
            }
            else
            {
                map.put(str, it+1);
                if(it + 1 > max)
                {
                    max = it + 1;
                    maxStr = str;
                }
                else if(it + 1 == max)
                {
                    if(maxStr.compareTo(str) > 0)
                        maxStr = str;
                }
            }
        }

        System.out.println(maxStr);
    }
}
