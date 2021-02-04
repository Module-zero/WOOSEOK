/*
트리

https://www.acmicpc.net/problem/1068
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-04
 * Time: 오후 10:05
 */

public class Q1068
{
    static int N;
    static ArrayList<Integer>[] child = new ArrayList[51];
    static int[] parent = new int[51];
    static boolean[] check = new boolean[51];

    public static void foo(int target)
    {
        check[target] = false;

        int p = parent[target];
        if(p != -1)
            child[p].remove(new Integer(target));

        for(int i=0; i<child[target].size(); i++)
        {
            int c = child[target].get(i);
            foo(c);
            i--;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            child[i] = new ArrayList<>();

        for(int i=0; i<N; i++)
            check[i] = true;

        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            parent[i] = num;

            if(num != -1)
                child[num].add(i);
        }

        int target = Integer.parseInt(br.readLine());
        foo(target);

        int cnt = 0;
        for(int i=0; i<N; i++)
        {
            if(!check[i])
                continue;

            if(child[i].size() == 0)
                cnt++;
        }

        System.out.println(cnt);
    }
}
