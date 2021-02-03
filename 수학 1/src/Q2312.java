/*
수 복원하기

https://www.acmicpc.net/problem/2312
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오전 1:08
 */

public class Q2312
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            int n = Integer.parseInt(br.readLine());
            TreeMap<Integer, Integer> map = new TreeMap<>();

            while(n > 1)
            {
                int i=2;
                while(i <= n)
                {
                    if(n % i == 0)
                        break;

                    i++;
                }

                Integer it = map.get(i);
                if(it == null)
                    map.put(i, 1);
                else
                    map.put(i, it + 1);

                n /= i;
            }

            Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
            while(it.hasNext())
            {
                Map.Entry<Integer, Integer> e = it.next();
                sb.append(e.getKey()).append(' ').append(e.getValue()).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
