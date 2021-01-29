/*
반복수열

https://www.acmicpc.net/problem/2331
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 8:49
 */

public class Q2331
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int prev = A;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(A, 1);
        for(int i=1; i<100; i++)
        {
            int sum = 0;
            while(prev > 0)
            {
                int rem = prev % 10;
                sum += Math.pow(rem, P);
                prev /= 10;
            }

            Integer it = map.get(sum);
            if(it == null)
                map.put(sum, 1);
            else
            {
                if(it == 2)
                    break;
                else
                    map.put(sum, it+1);
            }

            prev = sum;
        }

        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int cnt = 0;
        while(it.hasNext())
        {
            if(it.next().getValue() == 1)
                cnt++;
        }

        System.out.println(cnt);
    }
}
