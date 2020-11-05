/*
4연산

https://www.acmicpc.net/problem/14395
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오후 1:41
 */

public class Q14395
{
    static long limit = 1000000000L;

    static class Info
    {
        long num;
        StringBuilder sb;

        public Info(long num, StringBuilder sb)
        {
            this.num = num;
            this.sb = sb;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        char[] dc = {'*', '+', '-', '/'};
        long s = Long.parseLong(st.nextToken());
        long t = Long.parseLong(st.nextToken());

        if(s == t)
        {
            System.out.println(0);
            return;
        }

        Queue<Info> queue = new LinkedList<>();
        queue.add(new Info(s, new StringBuilder()));
        Set<Long> check = new TreeSet<>();
        check.add(s);

        while(!queue.isEmpty())
        {
            Info tmp = queue.poll();

            long num = tmp.num;

            // 정답이면 출력
            if(num == t)
            {
                System.out.println(tmp.sb.toString());
                return;
            }

            if(0 < num * num && num * num <= limit)
            {
                if(!check.contains(num*num))
                {
                    check.add(num*num);

                    queue.add(new Info(num*num, new StringBuilder(tmp.sb).append('*')));
                }
            }

            if(0 < num + num && num + num <= limit)
            {
                if(!check.contains(num+num))
                {
                    check.add(num+num);

                    queue.add(new Info(num+num, new StringBuilder(tmp.sb).append('+')));
                }
            }

            if(0 < num - num && num - num <= limit)
            {
                if(!check.contains(num-num))
                {
                    check.add(num-num);

                    queue.add(new Info(num-num, new StringBuilder(tmp.sb).append('-')));
                }
            }

            if(0 < num / num && num / num <= limit)
            {
                if(!check.contains(num/num))
                {
                    check.add(num/num);

                    queue.add(new Info(num/num, new StringBuilder(tmp.sb).append('/')));
                }
            }
        }

        System.out.println(-1);
    }
}
