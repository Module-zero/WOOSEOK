import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오전 1:00
 */

public class Q2637
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<int[]>[] need = new ArrayList[101];
        for(int i=1; i<=N; i++)
            need[i] = new ArrayList<>();

        int[] indeg = new int[101];
        for(int i=0; i<M; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            indeg[Y]++;
            need[X].add(new int[]{Y, K});
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] ans = new int[101];

        queue.add(N);
        ans[N] = 1;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            if(need[tmp].size() == 0)
                pq.add(tmp);

            for(int[] n : need[tmp])
            {
                indeg[n[0]]--;

                ans[n[0]] += ans[tmp] * n[1];
                if(indeg[n[0]] == 0)
                    queue.add(n[0]);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty())
        {
            int i = pq.poll();
            sb.append(i).append(' ').append(ans[i]).append('\n');
        }

        System.out.print(sb.toString());
    }
}
