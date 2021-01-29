/*
시리얼 번호

https://www.acmicpc.net/problem/1431
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 12:02
 */

public class Q1431
{
    static class Temp implements Comparable<Temp>
    {
        String str;

        public Temp(String str)
        {
            this.str = str;
        }

        @Override
        public int compareTo(Temp o)
        {
            int len = str.length();
            int olen = o.str.length();

            if(len == olen)
            {
                int sum = 0;
                int osum = 0;
                for(int i=0; i<len; i++)
                {
                    char ch = str.charAt(i);
                    char och = o.str.charAt(i);

                    if(ch >= '0' && ch <= '9')
                        sum += ch - '0';
                    if(och >= '0' && och <= '9')
                        osum += och - '0';
                }

                if(sum == osum)
                    return str.compareTo(o.str);
                else
                    return sum - osum;
            }
            else
                return len - olen;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        while(N-- > 0)
        {
            Temp tmp = new Temp(br.readLine());
            pq.add(tmp);
        }

        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty())
            sb.append(pq.poll().str).append('\n');

        System.out.print(sb.toString());
    }
}
