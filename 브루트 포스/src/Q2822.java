/*
점수 계산

https://www.acmicpc.net/problem/2822
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오전 2:51
 */

public class Q2822
{
    static class Temp implements Comparable<Temp>
    {
        int score;
        int id;

        public Temp(int score, int id)
        {
            this.score = score;
            this.id = id;
        }

        @Override
        public int compareTo(Temp o)
        {
            return score - o.score;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Temp[] ary = new Temp[8];
        for(int i=0; i<8; i++)
            ary[i] = new Temp(Integer.parseInt(br.readLine()), i+1);

        Arrays.sort(ary, 0, 8, Collections.reverseOrder());

        int sum = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0; i<5; i++)
        {
            sum += ary[i].score;
            pq.add(ary[i].id);
        }

        StringBuffer sb = new StringBuffer();
        sb.append(sum).append('\n');
        while(!pq.isEmpty())
            sb.append(pq.poll()).append(' ');

        System.out.println(sb.toString());
    }
}
