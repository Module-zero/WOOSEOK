import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-22
 * Time: 오후 2:46
 */

public class Q1922
{
    static class Temp implements Comparable<Temp>
    {
        int b;
        int c;

        public Temp(int b, int c)
        {
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Temp o)
        {
            return c - o.c;
        }
    }

    /*
    static int[] p = new int[1001];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;

        p[n] = find(p[n]);
        return p[n];
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b)
            return;

        p[a] += p[b];
        p[b] = a;
    }
    */

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<Temp>[] list = new ArrayList[1001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        while(M-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Temp(b, c));
            list[b].add(new Temp(a, c));
        }

        PriorityQueue<Temp> pq = new PriorityQueue<>();
        for(Temp t : list[1])
            pq.add(t);

        boolean[] check = new boolean[1001];
        check[1] = true;
        int ans = 0;
        while(!pq.isEmpty())
        {
            Temp t = pq.poll();
            if(check[t.b])
                continue;

            check[t.b] = true;
            ans += t.c;

            for(Temp next : list[t.b])
                pq.add(next);
        }

        System.out.println(ans);

        /*
        PriorityQueue<Temp> pq = new PriorityQueue<>();
        while(M-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Temp(a, b, c));
        }

        for(int i=1; i<=N; i++)
            p[i] = -1;

        int ans = 0;
        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();
            int a = find(tmp.a);
            int b = find(tmp.b);

            if(a == b)
                continue;

            merge(a, b);
            ans += tmp.c;
        }

        System.out.println(ans);
        */
    }
}
