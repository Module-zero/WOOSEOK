import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-27
 * Time: 오후 2:28
 */

public class Q1717
{
    static int[] p = new int[1000001];

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

        // b가 더 큰 트리면
        if(p[b] < p[a])
        {
            int tmp = b;
            b = a;
            a = tmp;
        }

        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0; i<=n; i++)
            p[i] = -1;

        StringBuffer sb = new StringBuffer();
        while(m-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int com = Integer.parseInt(st.nextToken());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if(com == 0)
                merge(a, b);
            else
            {
                if(find(a) == find(b))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }
}
