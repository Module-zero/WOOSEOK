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
 * Date: 2021-10-06
 * Time: 오후 6:51
 */

public class Q17471
{
    static int N;
    static int[] person = new int[11];
    static ArrayList<Integer>[] list = new ArrayList[11];
    static boolean[] check = new boolean[11];
    static int min = Integer.MAX_VALUE;

    public static void foo(int id)
    {
        if(id > N)
        {
            Queue<Integer> queue = new LinkedList<>();
            int[] group = new int[11];
            int gcnt = 0;
            for(int i=1; i<=N; i++)
            {
                if(group[i] == 0)
                {
                    queue.add(i);
                    group[i] = ++gcnt;
                    while(!queue.isEmpty())
                    {
                        int t = queue.poll();
                        for(int next : list[t])
                        {
                            if(group[next] != 0)
                                continue;

                            if(check[t] != check[next])
                                continue;

                            group[next] = gcnt;
                            queue.add(next);
                        }
                    }
                }
            }

            if(gcnt == 2)
            {
                int a = 0;
                int b = 0;
                for(int i=1; i<=N; i++)
                {
                    if(check[i])
                        a += person[i];
                    else
                        b += person[i];
                }

                if(a >= b)
                    min = Integer.min(min, a-b);
                else
                    min = Integer.min(min, b-a);
            }

            return;
        }

        foo(id+1);
        check[id] = true;
        foo(id+1);
        check[id] = false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++)
            person[i] = Integer.parseInt(st.nextToken());

        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            int lim = Integer.parseInt(st.nextToken());
            for(int j=0; j<lim; j++)
                list[i].add(Integer.parseInt(st.nextToken()));
        }

        foo(1);

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}
