import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-21
 * Time: 오후 3:29
 */

public class Q1939
{
    static ArrayList<int[]>[] list = new ArrayList[10001];
    static int x;
    static int y;
    static int weight;
    static boolean[] check;

    public static boolean foo(int id)
    {
        check[id] = true;

        if(id == y)
            return true;

        for(int[] tmp : list[id])
        {
            if(check[tmp[0]])
                continue;

            if(tmp[1] < weight)
                continue;

            if(foo(tmp[0]))
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for(int i=1; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int C = Integer.parseInt(st.nextToken());
            list[A].add(new int[]{B, C});
            list[B].add(new int[]{A, C});
        }

        st = new StringTokenizer(br.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        int start = 0;
        int end = 1000000000;
        int ans = 0;
        while(start <= end)
        {
            int mid = (start + end) / 2;
            weight = mid;
            check = new boolean[10001];

            if(foo(x))
            {
                ans = Integer.max(ans, mid);
                start = mid + 1;
            }
            else
                end = mid - 1;
        }

        System.out.println(ans);
    }
}
