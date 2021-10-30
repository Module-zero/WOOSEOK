import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-30
 * Time: 오후 7:16
 */

public class Q1647
{
    static class Temp implements Comparable<Temp>
    {
        int a;
        int b;
        int c;

        public Temp(int a, int b, int c)
        {
            this.a = a;
            this.b = b;
            this.c = c;
        }

        @Override
        public int compareTo(Temp o)
        {
            return c - o.c;
        }
    }

    static int[] p = new int[100001];

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

        if(p[b] < p[a])
        {
            int tmp = b;
            b = a;
            a = tmp;
        }

        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        PriorityQueue<Temp> pq = new PriorityQueue<>();

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            pq.add(new Temp(a, b, c));
        }

        for(int i=0; i<=N; i++)
            p[i] = -1;

        int cnt = N;
        int ans = 0;
        while(!pq.isEmpty())
        {
            Temp tmp = pq.poll();

            if(find(tmp.a) == find(tmp.b))
                continue;

            ans += tmp.c;
            merge(tmp.a, tmp.b);
            cnt--;
            if(cnt == 2)
                break;
        }

        System.out.println(ans);
    }
}
