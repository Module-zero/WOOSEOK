/*
수열 정렬

https://www.acmicpc.net/problem/1015
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 4:31
 */

public class Q1015
{
    static class Temp implements Comparable<Temp>
    {
        int id;
        int value;

        public Temp(int id, int value)
        {
            this.id = id;
            this.value = value;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(value == o.value)
                return id - o.id;
            else
                return value - o.value;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
        {
            int value = Integer.parseInt(st.nextToken());
            pq.add(new Temp(i, value));
        }

        int[] P = new int[51];
        int id = 0;
        while(!pq.isEmpty())
        {
            Temp tmp = pq.peek();
            P[tmp.id] = id++;
            pq.poll();
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
            sb.append(P[i]).append(' ');

        System.out.println(sb.toString());
    }
}
