import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-13
 * Time: 오전 12:31
 */

public class Q2253
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        boolean[] small = new boolean[10001];
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            small[index] = true;
        }

        boolean[][] check = new boolean[10001][150];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 1, 0});
        check[1][1] = true;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            int cur = tmp[0];
            int d = tmp[1];
            int cnt = tmp[2];

            int next = cur+d-1;

            if(next <= N && d-1 >= 1 && !check[next][d-1] && !small[next])
            {
                if(next == N)
                {
                    System.out.println(cnt+1);
                    return;
                }
                check[next][d-1] = true;
                queue.add(new int[]{next, d - 1, cnt + 1});
            }

            next++;
            if(next <= N && !check[next][d] && !small[next])
            {
                if(next == N)
                {
                    System.out.println(cnt+1);
                    return;
                }
                check[next][d] = true;
                queue.add(new int[]{next, d, cnt + 1});
            }

            next++;
            if(cur != 1 && next <= N && !check[next][d+1] && !small[next])
            {
                if(next == N)
                {
                    System.out.println(cnt+1);
                    return;
                }
                check[next][d+1] = true;
                queue.add(new int[]{next, d + 1, cnt + 1});
            }
        }

        System.out.println(-1);
    }
}
