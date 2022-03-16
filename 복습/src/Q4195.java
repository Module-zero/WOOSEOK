import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2022-03-16
 * Time: 오후 3:24
 */

public class Q4195
{
    static int[] p;

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

        p[a] += p[b];
        p[b] = a;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while(T-- > 0)
        {
            StringBuilder sb = new StringBuilder();
            int F = Integer.parseInt(br.readLine());

            int id = 0;
            Map<String, Integer> map = new HashMap<>();
            p = new int[200001];

            int max = 0;
            for(int i=0; i<F; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();
                String str2 = st.nextToken();
                Integer i1 = map.get(str1);
                Integer i2 = map.get(str2);

                if(i1 == null)
                {
                    map.put(str1, i1 = id++);
                    p[i1] = -1;
                }
                if(i2 == null)
                {
                    map.put(str2, i2 = id++);
                    p[i2] = -1;
                }

                merge(i1, i2);

                sb.append(-p[find(i1)]).append('\n');
            }

            System.out.print(sb.toString());
        }
    }
}
