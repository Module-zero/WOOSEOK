/*
생일

https://www.acmicpc.net/problem/5635
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-02
 * Time: 오후 11:38
 */

public class Q5635
{
    static class Temp implements Comparable<Temp>
    {
        String name;
        int year;
        int month;
        int day;

        public Temp(String name, int year, int month, int day)
        {
            this.name = name;
            this.year = year;
            this.month = month;
            this.day = day;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(year == o.year)
            {
                if(month == o.month)
                    return day - o.day;
                else
                    return month - o.month;
            }
            else
                return year - o.year;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        Temp[] ary = new Temp[101];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            String name = st.nextToken();
            int day = Integer.parseInt(st.nextToken());
            int month = Integer.parseInt(st.nextToken());
            int year = Integer.parseInt(st.nextToken());

            ary[i] = new Temp(name, year, month, day);
        }

        Arrays.sort(ary, 0, n);
        StringBuffer sb = new StringBuffer();
        sb.append(ary[n-1].name).append('\n').append(ary[0].name);
        System.out.println(sb.toString());
    }
}
