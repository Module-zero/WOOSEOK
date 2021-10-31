import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-31
 * Time: 오후 3:58
 */

public class Q21315
{
    public static void foo(int k, Queue<Integer> queue)
    {
        Queue<Integer> tmp = new LinkedList<>();

        int cnt = (int)Math.pow(2, k);
        for(int i=0; i<cnt; i++)
            tmp.add(queue.poll());

        while(cnt > 1)
        {
            cnt /= 2;

            for(int i=0; i<cnt; i++)
                tmp.add(tmp.poll());

            for(int i=0; i<cnt; i++)
                queue.add(tmp.poll());
        }

        queue.add(tmp.poll());
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[1001];
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int[] lim = {1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024};
        for(int i=1; i<=9; i++)
        {
            if(lim[i] >= N)
                break;

            for(int j=1; j<=9; j++)
            {
                if(lim[j] >= N)
                    break;

                Queue<Integer> queue = new LinkedList<>();

                for(int k=N; k>=1; k--)
                    queue.add(k);

                foo(i, queue);
                foo(j, queue);

                boolean isOk = true;
                for(int k=N-1; k>=0; k--)
                {
                    if(ary[k] != queue.poll())
                    {
                        isOk = false;
                        break;
                    }
                }

                if(isOk)
                {
                    System.out.println(i + " " + j);
                    return;
                }
            }
        }
    }
}
