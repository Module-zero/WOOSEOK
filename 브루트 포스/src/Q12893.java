import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-13
 * Time: 오후 10:25
 */

public class Q12893
{
    static int[] p = new int[2001];
    static int[] e = new int[2001];

    public static int find(int n)
    {
        if(p[n] < 0)
            return n;

        return p[n] = find(p[n]);
    }

    public static void merge(int a, int b)
    {
        a = find(a);
        b = find(b);

        if(a == b)
            return;

        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
        {
            p[i] = -1;
            e[i] = -1;
        }

        int ans = 1;
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            if(find(A) != find(B))
            {
                if(e[A] == -1)
                    e[A] = B;
                else
                    merge(e[A], B);

                if(e[B] == -1)
                    e[B] = A;
                else
                    merge(e[B], A);
            }
            else
            {
                ans = 0;
                break;
            }
        }

        for(int i=1; i<=N; i++)
            System.out.println(p[i]);
        System.out.println(ans);
    }
}
