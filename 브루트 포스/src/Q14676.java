import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-06
 * Time: 오전 2:15
 */

public class Q14676
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] deg = new int[100001];
        ArrayList<Integer>[] list = new ArrayList[100001];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            int Y = Integer.parseInt(st.nextToken());
            deg[Y]++;
            list[X].add(Y);
        }

        int[] cnt = new int[100001];
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());

            int com = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            if(com == 1)
            {
                if(deg[a] > 0)
                {
                    System.out.println("Lier!");
                    return;
                }
                else
                {
                    cnt[a]++;
                    if(cnt[a] == 1)
                    {
                        for(int next : list[a])
                            deg[next]--;
                    }
                }
            }
            else
            {
                if(cnt[a] == 0)
                {
                    System.out.println("Lier!");
                    return;
                }
                else
                {
                    cnt[a]--;
                    if(cnt[a] == 0)
                    {
                        for(int next : list[a])
                            deg[next]++;
                    }
                }
            }
        }

        System.out.println("King-God-Emperor");
    }
}
