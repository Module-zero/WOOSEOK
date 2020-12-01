/*
순회강연

https://www.acmicpc.net/problem/2109
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
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
        int p;
        int d;

        public Lecture(int p, int d)
        {
            this.p = p;
            this.d = d;
        }

        @Override
        public int compareTo(Lecture o)
        {
            if(d < o.d)
                return 1;
            else if(d == o.d)
            {
                if(p > o.p)
                    return -1;
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

        int n = Integer.parseInt(br.readLine());

        Lecture[] lectures = new Lecture[10001];

        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int p = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            lectures[i] = new Lecture(p, d);
        }

        // 유예기간이 많이 남을수록 앞에 온다.
        Arrays.sort(lectures, 0, n);

        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int sum = 0;

        int i = 0;
        for(int cur = 10000; cur > 0; cur--)
        {
            while(i < n && cur <= lectures[i].d)
            {
                queue.add(-lectures[i].p);
                i++;
            }

            if(!queue.isEmpty())
                sum += -queue.poll();
        }

        System.out.println(sum);
    }
}
