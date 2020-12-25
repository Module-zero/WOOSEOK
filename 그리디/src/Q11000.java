/*
강의실 배정

https://www.acmicpc.net/problem/11000
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
 * Date: 2020-12-24
 * Time: 오후 8:14
 */

public class Q11000
{
    static class Lecture implements Comparable<Lecture>
    {
        int S;
        int T;

        public Lecture(int S, int T)
        {
            this.S = S;
            this.T = T;
        }


        @Override
        public int compareTo(Lecture o)
        {
            if(S < o.S)
                return -1;
            else if(S == o.S)
                return T - o.T;
            else
                return 1;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Lecture[] lectures = new Lecture[200001];

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int T = Integer.parseInt(st.nextToken());
            lectures[i] = new Lecture(S, T);
        }

        Arrays.sort(lectures, 0, N);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
        {
            if(!pq.isEmpty())
            {
                if(lectures[i].S >= pq.peek())
                    pq.poll();
            }

            pq.add(lectures[i].T);
        }

        System.out.println(pq.size());
    }
}
