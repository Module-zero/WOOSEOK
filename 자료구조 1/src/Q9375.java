/*
패션왕 신해빈

https://www.acmicpc.net/problem/9375
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오전 1:43
 */

public class Q9375
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(tc-- > 0)
        {
            int n = Integer.parseInt(br.readLine());

            HashMap<String, Integer> map = new HashMap<>();
            while(n-- > 0)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String name = st.nextToken();
                String kind = st.nextToken();

                Integer i = map.get(kind);
                if(i == null)
                    map.put(kind, 1);
                else
                    map.put(kind, i+1);
            }

            Iterator<Integer> it = map.values().iterator();
            int sum = 1;
            while(it.hasNext())
                sum *= (it.next() + 1);

            sb.append(sum-1).append('\n');
        }

        System.out.print(sb.toString());
    }
}
