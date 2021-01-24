/*
촌수계산

https://www.acmicpc.net/problem/2644
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 8:16
 */

public class Q2644
{
    static int n;
    static int a;
    static int b;
    static int[] parent = new int[101];
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] check = new boolean[101];

    public static int foo(int node, int cnt)
    {
        check[node] = true;

        if(node == b)
            return cnt;

        int ret = -1;
        if(!check[parent[node]])
            ret = foo(parent[node], cnt+1);

        // 부모쪽에 있었을 경우 return
        if(ret != -1)
            return ret;

        int size = list.get(node).size();
        for(int i=0; i<size; i++)
        {
            int target = list.get(node).get(i);

            if(!check[target])
                ret = foo(target, cnt+1);

            if(ret != -1)
                return ret;
        }

        return ret;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = Integer.parseInt(st.nextToken());
        b = Integer.parseInt(st.nextToken());

        for(int i=1; i<=n; i++)
            parent[i] = i;
        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<=n; i++)
            list.add(new ArrayList<Integer>());

        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list.get(p).add(c);
            parent[c] = p;
        }

        System.out.println(foo(a, 0));
    }
}
