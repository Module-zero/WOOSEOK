import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-11-08
 * Time: 오후 7:56
 */

public class Q1043
{
    static int[] p = new int[51];
    static boolean[] check = new boolean[51];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;

        p[n] = find(p[n]);
        return p[n];
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);
        if(a == b)
            return;

        if(p[b] < p[a])
        {
            int tmp = b;
            b = a;
            a = tmp;
        }

        p[a] += p[b];
        p[b] = a;
        if(check[a] == false && check[b] == false)
            return;

        check[a] = check[b] = true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int X = Integer.parseInt(st.nextToken());
        for(int i=0; i<X; i++)
        {
            int t = Integer.parseInt(st.nextToken());
            check[t] = true;
        }

        for(int i=0; i<=N; i++)
            p[i] = -1;

        ArrayList<Integer>[] list = new ArrayList[51];
        for(int i=1; i<=M; i++)
            list[i] = new ArrayList<>();

        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());
            X = Integer.parseInt(st.nextToken());

            for(int j=0; j<X; j++)
                list[i].add(Integer.parseInt(st.nextToken()));
        }

        for(int i=1; i<=M; i++)
        {
            int size = list[i].size();
            int prev = list[i].get(0);

            for(int j=1; j<size; j++)
            {
                int cur = list[i].get(j);
                merge(prev, cur);
                prev = cur;
            }
        }

        int ans = 0;
        for(int i=1; i<=M; i++)
        {
            int size = list[i].size();

            ans++;
            for(int n : list[i])
            {
                n = find(n);
                if(check[n])
                {
                    ans--;
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}
