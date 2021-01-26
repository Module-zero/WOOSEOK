/*
신입 사원

https://www.acmicpc.net/problem/1946
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-26
 * Time: 오후 4:08
 */

public class Q1946
{
    static class Temp implements Comparable<Temp>
    {
        int first;
        int second;

        public Temp(int first, int second)
        {
            this.first = first;
            this.second = second;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(first == o.first)
                return second - o.second;

            return first - o.first;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            int n = Integer.parseInt(br.readLine());

            LinkedList<Temp> list = new LinkedList<>();
            for(int i=0; i<n; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int first = Integer.parseInt(st.nextToken());
                int second = Integer.parseInt(st.nextToken());

                list.add(new Temp(first, second));
            }

            Collections.sort(list);
            int maxSecond = list.get(0).second;
            Iterator<Temp> it = list.iterator();
            while(it.hasNext())
            {
                Temp tmp = it.next();

                if(tmp.second > maxSecond)
                    it.remove();
                else if(tmp.second < maxSecond)
                    maxSecond = tmp.second;
            }

            sb.append(list.size()).append('\n');
        }

        System.out.print(sb.toString());
    }
}
