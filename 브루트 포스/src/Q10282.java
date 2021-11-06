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
 * Time: 오전 2:02
 */

public class Q10282
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(tc-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ArrayList<int[]>[] list = new ArrayList[10001];
            for(int i=0; i<=n; i++)
                list[i] = new ArrayList<>();

            for(int i=0; i<d; i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int s = Integer.parseInt(st.nextToken());

                list[b].add(new int[]{a, s});
            }

            int[] dist = new int[10001];
            for(int i=0; i<=n; i++)
                dist[i] = 100000000;

            PriorityQueue<int[]> pq = new PriorityQueue<>(1001, new Comparator<int[]>()
            {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return o1[1] - o2[1];
                }
            });

            pq.add(new int[]{c, 0});
            dist[c] = 0;
            while(!pq.isEmpty())
            {
                int[] tmp = pq.poll();
                if(tmp[1] > dist[tmp[0]])
                    continue;

                for(int[] next : list[tmp[0]])
                {
                    int newd = tmp[1] + next[1];
                    if(newd < dist[next[0]])
                    {
                        dist[next[0]] = newd;
                        pq.add(new int[]{next[0], newd});
                    }
                }
            }

            int max = 0;
            int cnt = 1;
            for(int i=1; i<=n; i++)
            {
                if(i == c || dist[i] == 100000000)
                    continue;

                max = Integer.max(max, dist[i]);
                cnt++;
            }

            sb.append(cnt).append(' ').append(max).append('\n');
        }

        System.out.print(sb.toString());
    }
}
