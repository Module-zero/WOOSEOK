import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-23
 * Time: 오전 11:49
 */

public class Q2852
{
    static class Temp implements Comparable<Temp>
    {
        int id;
        int m;
        int s;

        public Temp(int id, int m, int s)
        {
            this.id = id;
            this.m = m;
            this.s = s;
        }

        @Override
        public int compareTo(Temp o)
        {
            if(m == o.m)
                return s - o.s;
            else
                return m - o.m;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(st.nextToken(), ":");

            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());

            pq.add(new Temp(t, m, s));
        }

        int[] m = new int[3];
        int[] s = new int[3];
        int[] score = new int[3];
        Temp prev = null;
        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            score[tmp.id]++;
            if(score[tmp.id] == score[3 - tmp.id])
            {
                if(tmp.s < prev.s)
                {
                    tmp.m--;
                    tmp.s += 60;
                }

                m[prev.id] += tmp.m - prev.m;
                s[prev.id] += tmp.s - prev.s;

                prev = null;
            }
            else if(score[tmp.id] > score[3 - tmp.id])
            {
                if(prev == null)
                    prev = tmp;
            }
            else
                continue;
        }

        if(prev != null)
        {
            int tm = 48;
            int ts = 0;

            if(ts < prev.s)
            {
                tm--;
                ts = 60;
            }

            m[prev.id] += tm - prev.m;
            s[prev.id] += ts - prev.s;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(String.format("%02d:%02d\n", m[1] + s[1] / 60, s[1] % 60));
        sb.append(String.format("%02d:%02d\n", m[2] + s[2] / 60, s[2] % 60));

        System.out.print(sb.toString());
    }
}
