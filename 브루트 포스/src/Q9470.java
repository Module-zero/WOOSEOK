import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-15
 * Time: 오전 12:57
 */

public class Q9470
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int K = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());

            int[] deg = new int[1001];
            ArrayList<Integer>[] list = new ArrayList[1001];
            for(int i=1; i<=M; i++)
                list[i] = new ArrayList<>();

            for(int i=0; i<P; i++)
            {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());

                deg[B]++;
                list[A].add(B);
            }

            int[] strahler = new int[1001];
            Queue<Integer> queue = new LinkedList<>();
            for(int i=1; i<=M; i++)
            {
                if(deg[i] == 0)
                {
                    queue.add(i);
                    strahler[i] = 1;
                }
            }

            int[][] ary = new int[1001][2];
            int ans = 1;
            while(!queue.isEmpty())
            {
                int tmp = queue.poll();

                for(int next : list[tmp])
                {
                    if(strahler[tmp] > ary[next][0])
                    {
                        ary[next][0] = strahler[tmp];
                        ary[next][1] = 1;
                    }
                    else if(strahler[tmp] == ary[next][0])
                        ary[next][1]++;

                    deg[next]--;
                    if(deg[next] == 0)
                    {
                        if(ary[next][1] >= 2)
                            strahler[next] = ary[next][0] + 1;
                        else
                            strahler[next] = ary[next][0];

                        queue.add(next);
                        ans = Integer.max(ans, strahler[next]);
                    }
                }
            }

            sb.append(K).append(' ').append(ans).append('\n');
        }

        System.out.print(sb.toString());
    }
}
