/*
순열 사이클

https://www.acmicpc.net/problem/10451
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 5:29
 */

public class Q10451
{
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] check;

    public static void dfs(int node)
    {
        check[node] = true;

        int target = list.get(node).get(0);
        if(check[target])
            return;

        dfs(target);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            int N = Integer.parseInt(br.readLine());
            list = new ArrayList<>();
            for(int i=0; i<=N; i++)
                list.add(new ArrayList<>());

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=1; i<=N; i++)
            {
                int a = Integer.parseInt(st.nextToken());

                list.get(i).add(a);
            }

            int cnt = 0;
            check = new boolean[1001];
            for(int i=1; i<=N; i++)
            {
                if(check[i])
                    continue;

                dfs(i);
                cnt++;
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
