import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-20
 * Time: 오후 2:51
 */

public class Q4803
{
    static int[] p;
    static boolean[] cycle;

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

        p[a] += p[b];
        if(!cycle[a])
            cycle[a] = cycle[b];

        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int tc = 1;
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0)
                break;

            p = new int[501];
            for(int i=0; i<=n; i++)
                p[i] = -1;

            cycle = new boolean[501];
            for(int i=0; i<m; i++)
            {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                if(find(a) != find(b))
                    merge(a, b);
                else
                    cycle[find(a)] = true;
            }

            HashSet<Integer> set = new HashSet<>();
            for(int i=1; i<=n; i++)
            {
                int a = find(i);
                if(cycle[a])
                    continue;

                set.add(a);
            }

            sb.append("Case ").append(tc).append(": ");
            int cnt = set.size();
            switch(cnt)
            {
                case 0:
                    sb.append("No trees.\n");
                    break;
                case 1:
                    sb.append("There is one tree.\n");
                    break;
                default:
                    sb.append("A forest of ").append(cnt).append(" trees.\n");
                    break;
            }

            tc++;
        }

        System.out.print(sb.toString());
    }
}
