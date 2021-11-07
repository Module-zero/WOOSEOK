import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-07
 * Time: 오후 5:08
 */

public class Q15970
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer>[] pq = new PriorityQueue[5001];
        for(int i=1; i<=N; i++)
            pq[i] = new PriorityQueue<>();

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            pq[y].add(x);
        }

        int ans = 0;

        for(int i=1; i<=N; i++)
        {
            int prev = -1;

            while(!pq[i].isEmpty())
            {
                int cur = pq[i].poll();

                if(pq[i].isEmpty())
                {
                    ans += cur - prev;
                    break;
                }

                int next = pq[i].peek();
                if(prev == -1)
                    ans += next - cur;
                else
                    ans += Integer.min(cur - prev, next - cur);

                prev = cur;
            }
        }

        System.out.println(ans);
    }
}
