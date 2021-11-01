import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-01
 * Time: 오후 12:40
 */

public class Q1504
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

        public int compareTo(Temp o)
        {
            return c - o.c;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());

        int[][] d = new int[3][801];
        for(int i=0; i<3; i++)
        {
            for(int j=0; j<=N; j++)
                d[i][j] = 99999999;
        }

        ArrayList<Temp>[] list = new ArrayList[801];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        while(E-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            list[a].add(new Temp(b, c));
            list[b].add(new Temp(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        PriorityQueue<int[]> pq = new PriorityQueue<>(20000, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o1[1] - o2[1];
            }
        });

        int[] target = {1, v1, v2};
        for(int i=0; i<3; i++)
        {
            pq.add(new int[]{target[i], 0});
            d[i][target[i]] = 0;
            while(!pq.isEmpty())
            {
                int[] tmp = pq.poll();

                if(d[i][tmp[0]] < tmp[1])
                    continue;

                for(Temp t : list[tmp[0]])
                {
                    int dist = tmp[1] + t.c;
                    if(dist < d[i][t.b])
                    {
                        d[i][t.b] = dist;
                        pq.add(new int[]{t.b, dist});
                    }
                }
            }
        }

        int dist = Integer.min(d[0][v1] + d[1][v2] + d[2][N], d[0][v2] + d[2][v1] + d[1][N]);
        if(dist >= 99999999)
            dist = -1;

        System.out.println(dist);
    }
}
