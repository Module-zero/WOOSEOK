/*
나3곱2

https://www.acmicpc.net/problem/16936
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-11
 * Time: 오후 9:42
 */

public class Q16936
{
    static class Temp implements Comparable<Temp>
    {
        long num;
        int div3Cnt;

        public Temp(long num)
        {
            this.num = num;
        }

        @Override
        public int compareTo(Temp o)
        {
            // 3으로 나누는 횟수가 많은 아이가 앞으로
            if(div3Cnt < o.div3Cnt)
                return 1;
            else if(div3Cnt == o.div3Cnt)
            {
                if(num < o.num)
                    return -1;
                else if(num == o.num)
                    return 0;
                else
                    return 1;
            }
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st= new StringTokenizer(br.readLine());

        ArrayList<Temp> ary = new ArrayList<>();
        for(int i=0; i<N; i++)
            ary.add(new Temp(Long.parseLong(st.nextToken())));

        for(int i=0; i<N; i++)
        {
            long tmp = ary.get(i).num;

            int n = 0;
            while(true)
            {
                // 3으로 나누어 떨어지면 진행
                if(tmp % 3 == 0)
                {
                    n++;
                    tmp /= 3;
                }
                else
                    break;
            }

            ary.get(i).div3Cnt = n;
        }

        Collections.sort(ary);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<N; i++)
            sb.append(ary.get(i).num).append(' ');

        System.out.println(sb.toString());
    }
}
