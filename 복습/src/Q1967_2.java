import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-20
 * Time: 오후 1:25
 */

public class Q1967_2
{
    static int n;
    static ArrayList<int[]>[] list = new ArrayList[10001];
    static int max = 0;
    static int ans = 0;
    static boolean[] check = new boolean[10001];

    public static void foo(int id, int dist)
    {
        check[id] = true;

        int len = list[id].size();
        for(int i=0; i<len; i++)
        {
            int[] tmp = list[id].get(i);
            if(check[tmp[0]])
                continue;

            foo(tmp[0], dist + tmp[1]);
        }

        if(dist > max)
        {
            max = dist;
            ans = id;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<n-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            list[id].add(new int[]{target, d});
            list[target].add(new int[]{id, d});
        }

        foo(1, 0);
        check = new boolean[10001];
        foo(ans, 0);

        System.out.println(max);
    }
}
