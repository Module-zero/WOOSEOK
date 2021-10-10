import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-10
 * Time: 오전 1:22
 */

public class Q2457
{
    static int[] d = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    static class Temp
    {
        int sm;
        int sd;
        int em;
        int ed;

        public Temp(int sm, int sd, int em, int ed)
        {
            this.sm = sm;
            this.sd = sd;
            this.em = em;
            this.ed = ed;
        }

        public String toString()
        {
            return sm + " : " + sd + " : " + em + " : " + ed;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Temp> start = new PriorityQueue<>(100001, new Comparator<Temp>()
        {
            @Override
            public int compare(Temp o1, Temp o2)
            {
                if(o1.em == o2.em)
                    return o2.ed - o1.ed;
                else
                    return o2.em - o1.em;
            }
        });

        PriorityQueue<Temp> mid = new PriorityQueue<>(100001, new Comparator<Temp>()
        {
            @Override
            public int compare(Temp o1, Temp o2)
            {
                if(o1.sm == o2.sm)
                {
                    if(o1.sd == o2.sd)
                    {
                        if(o1.em == o2.ed)
                            return o1.ed - o2.ed;
                        else
                            return o1.em - o2.em;
                    }
                    else
                        return o1.sd - o2.sd;
                }
                else
                    return o1.sm - o2.sm;
            }
        });

        PriorityQueue<Temp> end = new PriorityQueue<>(100001, new Comparator<Temp>()
        {
            @Override
            public int compare(Temp o1, Temp o2)
            {
                if(o1.sm == o2.sm)
                    return o1.sd - o2.sd;
                else
                    return o1.sm - o2.sm;
            }
        });
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());

            Temp tmp = new Temp(sm, sd, em, ed);
            if(sm <= 3)
            {
                if(sm == 3 && sd > 1)
                    mid.add(tmp);
                else
                    start.add(tmp);
            }
            else if(em >= 12)
                end.add(tmp);
            else
                mid.add(tmp);
        }

        Temp stmp = start.poll();
        if(stmp.em == 12)
        {
            System.out.println(1);
            return;
        }

        Temp etmp = end.poll();
        if(etmp.sm <= 3)
        {
            if(etmp.sm < 3 || (etmp.sm == 3 && etmp.sd == 1))
            {
                System.out.println(1);
                return;
            }
        }

        if(stmp.em >= etmp.sm)
        {
            if(stmp.em == etmp.sm)
            {
                if(stmp.ed >= etmp.sd)
                {
                    System.out.println(2);
                    return;
                }
            }
            else
            {
                System.out.println(2);
                return;
            }
        }

        int cnt = 2;
        boolean isFound = false;
        while(!mid.isEmpty())
        {
            Temp tmp = mid.poll();

            if(tmp.sm <= stmp.em)
            {
                if(tmp.sm == stmp.em)
                {
                    if(tmp.sd <= stmp.ed)
                        isFound = true;
                }
                else
                    isFound = true;
            }

            if(isFound)
            {
                isFound = false;
            }
            else
            {

            }
        }
    }
}
