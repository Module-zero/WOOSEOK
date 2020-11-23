/*
바이러스

https://www.acmicpc.net/problem/2606
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-18
 * Time: 오후 5:05
 */

public class Q2606
{
    static int[] parent = new int[101];
    static int[] rank = new int[101];

    public static int find(int n)
    {
        if(n == parent[n])
            return n;
        else
            return parent[n] = find(parent[n]);
    }

    public static void merge(int n1, int n2)
    {
        n1 = find(n1);
        n2 = find(n2);

        if(n1 == n2)
            return;

        // 항상 n2가 깊이가 작은 트리가 되게 한다.
        if(rank[n1] < rank[n2])
        {
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        parent[n2] = n1;
        if(rank[n1] == rank[n2])
            rank[n1]++;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        for(int i=1; i<=n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n1 = Integer.parseInt(st.nextToken());
            int n2 = Integer.parseInt(st.nextToken());

            merge(n1, n2);
        }

        int cnt = 0;
        for(int i=2; i<=n; i++)
        {
            if(parent[1] == find(i))
                cnt++;
        }

        System.out.println(cnt);
    }
}
