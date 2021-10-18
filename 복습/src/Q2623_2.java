import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-18
 * Time: 오후 3:04
 */

public class Q2623_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] deg = new int[1001];
        ArrayList<Integer>[] list = new ArrayList[1001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());

            int prev = Integer.parseInt(st.nextToken());
            while(num-- > 1)
            {
                int next = Integer.parseInt(st.nextToken());
                list[prev].add(next);
                deg[next]++;

                prev = next;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            if(deg[i] == 0)
                queue.add(i);
        }

        StringBuffer sb = new StringBuffer();
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();
            sb.append(tmp).append('\n');

            for(int next : list[tmp])
            {
                deg[next]--;
                if(deg[next] == 0)
                    queue.add(next);
            }
        }

        for(int i=1; i<=N; i++)
        {
            if(deg[i] != 0)
            {
                System.out.println(0);
                return;
            }
        }

        System.out.print(sb.toString());
    }
}
