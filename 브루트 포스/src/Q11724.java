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
 * Date: 2022-03-15
 * Time: 오후 9:58
 */

public class Q11724
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[1001];
        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            list[u].add(v);
            list[v].add(u);
        }

        Queue<Integer> queue = new LinkedList<>();
        boolean[] check = new boolean[1001];
        int gCnt = 0;
        for(int i=1; i<=N; i++)
        {
            if(check[i])
                continue;

            check[i] = true;
            ++gCnt;
            queue.add(i);
            while(!queue.isEmpty())
            {
                int tmp = queue.poll();

                for(int next : list[tmp])
                {
                    if(check[next])
                        continue;

                    check[next] = true;
                    queue.add(next);
                }
            }
        }

        System.out.println(gCnt);
    }
}
