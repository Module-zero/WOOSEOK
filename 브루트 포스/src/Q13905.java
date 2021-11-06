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
 * Date: 2021-11-06
 * Time: 오전 12:40
 */

public class Q13905
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        ArrayList<int[]>[] list = new ArrayList[100001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int h1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            list[h1].add(new int[]{h2, k});
            list[h2].add(new int[]{h1, k});
        }

        int[] dist = new int[100001];

        PriorityQueue<int[]> pq = new PriorityQueue<>(100001, new Comparator<int[]>()
        {
            @Override
            public int compare(int[] o1, int[] o2)
            {
                return o2[1] - o1[1];
            }
        });

        pq.add(new int[]{s, 200000});
        dist[s] = 200000;
        while(!pq.isEmpty())
        {
            int[] tmp = pq.poll();
            if(tmp[1] < dist[tmp[0]])
                continue;

            for(int[] next : list[tmp[0]])
            {
                int newW = Integer.min(tmp[1], next[1]);
                if(newW > dist[next[0]])
                {
                    dist[next[0]] = newW;
                    pq.add(new int[]{next[0], newW});
                }
            }
        }

        System.out.println(dist[e]);
    }
}
