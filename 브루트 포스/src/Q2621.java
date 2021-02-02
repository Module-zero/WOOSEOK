/*
카드게임

https://www.acmicpc.net/problem/2621
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 5:07
 */

public class Q2621
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] colors = new char[5];
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        for(int i=0; i<5; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char ch = st.nextToken().charAt(0);
            int num = Integer.parseInt(st.nextToken());
            colors[i] = ch;

            Integer it = map.get(num);
            if(it == null)
                map.put(num, 1);
            else
                map.put(num, it+1);
        }

        boolean isSame = true;
        for(int i=0; i<4; i++)
        {
            if(colors[i] != colors[i+1])
            {
                isSame = false;
                break;
            }
        }

        boolean isSequence = true;
        int cnt = 1;
        Iterator<Map.Entry<Integer, Integer>> it = map.entrySet().iterator();
        int prev = it.next().getKey();
        int max = prev;
        while(it.hasNext())
        {
            Map.Entry<Integer, Integer> e = it.next();
            if(e.getKey() != prev - 1)
            {
                isSequence = false;
                break;
            }

            prev = e.getKey();
            cnt++;
        }

        if(isSame)
        {
            // 연속적
            if(cnt == 5 && isSequence)
                System.out.println(max + 900);
            else
                System.out.println(max + 600);
        }
        else
        {
            it = map.entrySet().iterator();

            ArrayList<Integer>[] list = new ArrayList[5];
            for(int i=0; i<5; i++)
                list[i] = new ArrayList<>();

            while(it.hasNext())
            {
                Map.Entry<Integer, Integer> e = it.next();
                list[e.getValue()].add(e.getKey());
            }

            if(list[4].size() == 1)
                System.out.println(list[4].get(0) + 800);
            else if(list[3].size() == 1 && list[2].size() == 1)
                System.out.println(list[3].get(0) * 10 + list[2].get(0) + 700);
            else if(cnt == 5 && isSequence)
                System.out.println(max + 500);
            else if(list[3].size() == 1)
                System.out.println(list[3].get(0) + 400);
            else if(list[2].size() == 2)
            {
                if(list[2].get(0) > list[2].get(1))
                {
                    max = list[2].get(0);
                    int min = list[2].get(1);
                    System.out.println(max * 10 + min + 300);
                }
                else
                {
                    max = list[2].get(1);
                    int min = list[2].get(0);
                    System.out.println(max * 10 + min + 300);
                }
            }
            else if(list[2].size() == 1)
                System.out.println(list[2].get(0) + 200);
            else
                System.out.println(max + 100);
        }
    }
}
