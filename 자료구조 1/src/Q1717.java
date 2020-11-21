/*
집합의 표현

https://www.acmicpc.net/problem/1717
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-22
 * Time: 오전 1:03
 */

public class Q1717
{
    static int[] parent = new int[1000001];
    static int[] rank = new int[1000001];

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
        // 부모가 같으면 이미 합쳐져있음
        if(n1 == n2)
            return;

        // 항상 n2가 깊이가 작은 트리가 되도록
        if(rank[n1] < rank[n2])
        {
            int tmp = n1;
            n1 = n2;
            n2 = tmp;
        }

        // 깊이가 작은 트리를 큰 트리로 합침
        parent[n2] = n1;

        if(rank[n1] == rank[n2])
            rank[n1]++;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 부모를 자신으로 초기화
        for(int i=0; i<=n; i++)
        {
            parent[i] = i;
            rank[i] = 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(br.readLine());

            int command = Integer.parseInt(st.nextToken());
            int num1 = Integer.parseInt(st.nextToken());
            int num2 = Integer.parseInt(st.nextToken());

            // 합집합
            if(command == 0)
                merge(num1, num2);
            // 확인
            else
            {
                if(find(num1) == find(num2))
                    sb.append("YES\n");
                else
                    sb.append("NO\n");
            }
        }

        System.out.print(sb.toString());
    }
}
