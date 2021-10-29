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
 * Date: 2021-10-29
 * Time: 오후 2:33
 */

public class Q1707
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(K-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            ArrayList<Integer>[] list = new ArrayList[20001];
            for(int i=1; i<=V; i++)
                list[i] = new ArrayList<>();

            while(E-- > 0)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }

            int[] color = new int[20001];
            Queue<Integer> queue = new LinkedList<>();
            boolean exit = false;
            for(int i=1; i<=V; i++)
            {
                if(color[i] != 0)
                    continue;

                color[i] = 1;
                queue.add(i);
                while(!queue.isEmpty())
                {
                    int tmp = queue.poll();

                    for(int next : list[tmp])
                    {
                        if(color[next] == color[tmp])
                        {
                            exit = true;
                            break;
                        }

                        if(color[next] != 0)
                            continue;

                        color[next] = 3 - color[tmp];
                        queue.add(next);
                    }

                    if(exit)
                        break;
                }

                if(exit)
                    break;
            }

            if(exit)
                sb.append("NO\n");
            else
                sb.append("YES\n");
        }

        System.out.print(sb.toString());
    }
}
