import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-10-02
 * Time: 오후 7:40
 */

public class Q15900
{
    static ArrayList<Integer>[] list = new ArrayList[500001];
    static boolean[] check = new boolean[500001];
    static int ans = 0;

    public static void dfs(int id, int cnt)
    {
        if(list[id].size() == 1 && id != 1)
        {
            ans += cnt;
            return;
        }

        for(int i : list[id])
        {
            if(check[i])
                continue;

            check[i] = true;
            dfs(i, cnt+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        for(int i=0; i<N-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
            list[b].add(a);
        }

        /*
        Queue<Integer> queue = new LinkedList<>();
        int[] cnt = new int[500001];
        boolean[] check = new boolean[500001];
        check[1] = true;
        queue.add(1);
        boolean[] hasChildren = new boolean[500001];
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            int c = 0;
            for(int i : list[tmp])
            {
                if(check[i])
                    continue;

                cnt[i] = cnt[tmp] + 1;
                check[i] = true;
                queue.add(i);
                c++;
            }

            if(c != 0)
                hasChildren[tmp] = true;
        }

        int ans = 0;
        for(int i=1; i<=N; i++)
        {
            if(!hasChildren[i])
                ans += cnt[i];
        }

        if(ans % 2 == 0)
            System.out.println("No");
        else
            System.out.println("Yes");
        */

        check[1] = true;
        dfs(1, 0);
        System.out.println(ans % 2 == 1 ? "Yes" : "No");
    }
}
