/*
생태학

https://www.acmicpc.net/problem/4358
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-05
 * Time: 오후 12:09
 */

public class Q4358
{
    static class Value
    {
        int cnt;

        public Value()
        {
            cnt = 1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int total = 0;
        TreeMap<String, Value> map = new TreeMap<>();
        while(true)
        {
            String str = br.readLine();
            if(str == null)
                break;

            total++;
            if(map.containsKey(str))
                map.get(str).cnt++;
            else
                map.put(str, new Value());
        }

        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, Value>> it = map.entrySet().iterator();
        while(it.hasNext())
        {
            Map.Entry<String, Value> entry = it.next();

            sb.append(entry.getKey()).append(' ').append(String.format("%.4f\n", ((double)entry.getValue().cnt/total)*100));
        }

        System.out.print(sb.toString());
    }
}
