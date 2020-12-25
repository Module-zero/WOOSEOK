/*
친구 네트워크

https://www.acmicpc.net/problem/4195
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-24
 * Time: 오후 10:32
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

        int tc = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(tc-- > 0)
        {
            TreeMap<String, Integer> map = new TreeMap<>();
            p = new int[200001];

            int F = Integer.parseInt(br.readLine());
            int id = 0;
            for(int i=0; i<F; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String str1 = st.nextToken();
                String str2 = st.nextToken();
                int id1=0;
                int id2=0;

                if(map.containsKey(str1))
                    id1 = map.get(str1);
                else
                {
                    map.put(str1, id);
                    p[id] = -1;
                    id1 = id++;
                }

                if(map.containsKey(str2))
                    id2 = map.get(str2);
                else
                {
                    map.put(str2, id);
                    p[id] = -1;
                    id2 = id++;
                }

                if(find(id1) != find(id2))
                    merge(id1, id2);

                sb.append(-p[find(id1)]).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
