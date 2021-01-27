/*
올림픽

https://www.acmicpc.net/problem/8979
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 11:25
 */

public class Q8979
{
    static class Temp implements Comparable<Temp>
    {
        int nation;
        int gold;
        int silver;
        int bronze;

        public Temp(int nation, int gold, int silver, int bronze)
        {
            this.nation = nation;
            this.gold = gold;
            this.silver = silver;
            this.bronze = bronze;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(gold == o.gold)
            {
                if(silver == o.silver)
                    return bronze - o.bronze;
                else
                    return silver - o.silver;
            }
            else
                return gold - o.gold;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Temp> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int nation = Integer.parseInt(st.nextToken());
            int gold = Integer.parseInt(st.nextToken());
            int silver = Integer.parseInt(st.nextToken());
            int bronze = Integer.parseInt(st.nextToken());

            pq.add(new Temp(nation, gold, silver, bronze));
        }

        int rank = 1;
        int cnt = 1;
        Temp prev = pq.poll();
        while(prev.nation != K && !pq.isEmpty())
        {
            cnt++;

            Temp cur = pq.poll();

            if(prev.gold != cur.gold || prev.silver != cur.silver || prev.bronze != cur.bronze)
                rank = cnt;

            prev = cur;
        }

        System.out.println(rank);
    }
}
