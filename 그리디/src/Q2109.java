/*
순회강연

https://www.acmicpc.net/problem/2109
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-03
 * Time: 오후 4:02
 */

public class Q2109
{
    static class Lecture implements Comparable<Lecture>
    {
        int d;
        int p;

        public Lecture(int d, int p)
        {
            this.d = d;
            this.p = p;
        }

        @Override
        public int compareTo(Lecture o)
        {
            if(d < o.d)
                return 1;
            else if(d == o.d)
            {
                if(p < o.p)
                    return 1;
                else if(p == o.p)
                    return 0;
                else
                    return -1;
            }
            else
                return -1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Lecture> queue = new PriorityQueue<>();
        int prevD = 0;
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            queue.add(new Lecture(d, p));
            if(prevD != d)
            {
                queue.add(new Lecture(d, 0));
                prevD = d;
            }
        }

        while(!queue.isEmpty())
        {
            System.out.println(queue.peek().d + " : " + queue.poll().p);
        }

        int sum = 0;
        for(int i=0; i<n; i++)
        {
        }

        System.out.println(sum);
    }
}
