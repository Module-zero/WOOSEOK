/*
인기 투표

https://www.acmicpc.net/problem/11637
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-26
 * Time: 오후 4:53
 */

public class Q11637
{
    static class Rep implements Comparable<Rep>
    {
        int num;
        int id;

        public Rep(int num, int id)
        {
            this.num = num;
            this.id = id;
        }

        @Override
        public int compareTo(Rep o)
        {
            return o.num - num;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        Rep[] ary = new Rep[11];
        while(T-- > 0)
        {
            int sum = 0;
            int n = Integer.parseInt(br.readLine());

            for(int i=1; i<=n; i++)
            {
                ary[i] = new Rep(Integer.parseInt(br.readLine()), i);
                sum += ary[i].num;
            }

            sum /= 2;
            Arrays.sort(ary, 1, n+1);

            if(ary[1].num == ary[2].num)
                sb.append("no winner").append('\n');
            else if(ary[1].num <= sum)
                sb.append("minority winner ").append(ary[1].id).append('\n');
            else
                sb.append("majority winner ").append(ary[1].id).append('\n');
        }

        System.out.print(sb.toString());
    }
}
