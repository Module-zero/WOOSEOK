/*
트리의 부모 찾기

https://www.acmicpc.net/problem/11725
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-24
 * Time: 오후 11:34
 */

public class Q11725
{
    static int N;
    static ArrayList<ArrayList<Integer>> ary = new ArrayList<>();
    static int[] parent;
    static boolean[] check;
    static int root = 1;

    public static void preorder(int data, int prev)
    {
        check[data] = true;
        parent[data] = prev;

        int size = ary.get(data).size();
        for(int i=0; i<size; i++)
        {
            ArrayList<Integer> list = ary.get(data);
            int next = list.get(i);

            if(!check[next])
                preorder(next, data);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        N  = Integer.parseInt(br.readLine());
        parent = new int[N+1];
        check = new boolean[N+1];

        for(int i=0; i<=N; i++)
            ary.add(new ArrayList<>());

        for(int i=0; i<N-1; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int id1 = Integer.parseInt(st.nextToken());
            int id2 = Integer.parseInt(st.nextToken());

            // 두 점을 연결
            ary.get(id1).add(id2);
            ary.get(id2).add(id1);
        }

        preorder(root, 0);

        for(int i=2; i<=N; i++)
            sb.append(parent[i] + "\n");

        System.out.print(sb.toString());
    }
}
