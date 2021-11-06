import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오전 1:01
 */

public class Q16202
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        LinkedList<int[]>[] list = new LinkedList[1001];
        for(int i=0; i<=N; i++)
            list[i] = new LinkedList<>();

        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            list[x].add(new int[]{y, i});
            list[y].add(new int[]{x, i});
        }

        int cnt = 0;
        StringBuffer sb = new StringBuffer();
        boolean[] rem = new boolean[10001];

        while(cnt < K)
        {
            int min = 15000;
            int ans = 0;

            PriorityQueue<int[]> pq = new PriorityQueue<>(10001, new Comparator<int[]>()
            {
                @Override
                public int compare(int[] o1, int[] o2)
                {
                    return o1[1] - o2[1];
                }
            });

            Queue<Integer> queue = new LinkedList<>();
            boolean[] check = new boolean[1001];
            queue.add(1);
            while(!queue.isEmpty())
            {
                int t = queue.poll();
                check[t] = true;

                for(int[] next : list[t])
                {
                    if(check[next[0]])
                        continue;
                    if(rem[next[1]])
                        continue;

                    pq.add(new int[]{next[0], next[1]});
                }

                while(!pq.isEmpty())
                {
                    int[] tmp = pq.poll();
                    if(check[tmp[0]])
                        continue;

                    queue.add(tmp[0]);
                    ans += tmp[1];
                    if(tmp[1] < min)
                        min = tmp[1];

                    break;
                }
            }

            boolean ok = true;
            for(int i=1; i<=N; i++)
            {
                if(!check[i])
                {
                    ok = false;
                    break;
                }
            }

            if(!ok)
                break;

            rem[min] = true;
            sb.append(ans).append(' ');
            cnt++;
        }

        while(cnt < K)
        {
            sb.append("0 ");
            cnt++;
        }

        System.out.println(sb.toString());
    }
}
