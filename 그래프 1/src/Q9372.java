/*
상근이의 여행

https://www.acmicpc.net/problem/9372
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-27
 * Time: 오후 10:16
 */

public class Q9372
{
    static ArrayList<ArrayList<Integer>> ary;
    static boolean[] check;
    static int cnt;

    public static void dfs(int node)
    {
        check[node] = true;
        cnt++;

        int size = ary.get(node).size();
        for(int i=0; i<size; i++)
        {
            int next = ary.get(node).get(i);
            if(!check[next])
                dfs(next);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            ary = new ArrayList<>();
            for(int i=0; i<=N; i++)
                ary.add(new ArrayList<>());

            for(int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                ary.get(a).add(b);
                ary.get(b).add(a);
            }

            check = new boolean[1001];
            cnt = 0;

            dfs(1);
            sb.append(cnt-1).append('\n');
        }

        System.out.print(sb.toString());
    }
}
