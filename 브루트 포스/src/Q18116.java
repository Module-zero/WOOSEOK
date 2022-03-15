import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-14
 * Time: 오후 4:08
 */

public class Q18116
{
    static int[] p = new int[1000001];

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

        if(p[b] < p[a])
        {
            int tmp = p[b];
            p[b] = p[a];
            p[a] = tmp;
        }

        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=1; i<=1000000; i++)
            p[i] = -1;

        int N = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while(N-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char ch = st.nextToken().charAt(0);
            if(ch == 'I')
            {
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                merge(a, b);
            }
            else if(ch == 'Q')
            {
                int c = Integer.parseInt(st.nextToken());
                sb.append(-p[find(c)]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
