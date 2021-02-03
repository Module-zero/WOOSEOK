/*
후보 추천하기

https://www.acmicpc.net/problem/1713
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 1:19
 */

public class Q1713
{
    static class Temp implements Comparable<Temp>
    {
        int id;
        int order;
        int cnt;

        public Temp(int id, int order, int cnt)
        {
            this.id = id;
            this.order = order;
            this.cnt = cnt;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(cnt == o.cnt)
                return order - o.order;
            else
                return cnt - o.cnt;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int num = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Temp> pq = new PriorityQueue<>();

        for(int i=0; i<num; i++)
        {
            int id = Integer.parseInt(st.nextToken());
            int order = i;

            Temp tmp = new Temp(id, order, 1);

            Iterator<Temp> it = pq.iterator();
            boolean found = false;
            while(it.hasNext())
            {
                Temp t = it.next();

                if(t.id == tmp.id)
                {
                    tmp.cnt = t.cnt + 1;
                    tmp.order = t.order;
                    it.remove();
                    pq.add(tmp);
                    found = true;
                    break;
                }
            }
            if(found)
                continue;

            if(pq.size() == N)
                pq.poll();

            pq.add(tmp);
        }

        ArrayList<Integer> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        while(!pq.isEmpty())
            list.add(pq.poll().id);

        Collections.sort(list);
        for(int i : list)
            sb.append(i).append(' ');
        System.out.println(sb.toString());
    }
}
