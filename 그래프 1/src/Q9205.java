/*
맥주 마시면서 걸어가기

https://www.acmicpc.net/problem/9205
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오후 8:18
 */

public class Q9205
{
    static ArrayList<ArrayList<Integer>> list;
    static boolean[] check;
    static int n;

    public static boolean dfs(int node)
    {
        check[node] = true;
        if(node == n+1)
            return true;

        int size = list.get(node).size();
        for(int i=0; i<size; i++)
        {
            int next = list.get(node).get(i);
            if(!check[next])
            {
                if(dfs(next))
                    return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine());
        while(t-- > 0)
        {
            n = Integer.parseInt(br.readLine());
            check = new boolean[102];
            list = new ArrayList<>();
            for(int i=0; i<n+2; i++)
                list.add(new ArrayList<>());

            int[] r = new int[102];
            int[] c = new int[102];
            for(int i=0; i<n+2; i++)
            {
                StringTokenizer st = new StringTokenizer(br.readLine());
                r[i] = Integer.parseInt(st.nextToken());
                c[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=0; i<n+1; i++)
            {
                for(int j=i+1; j<n+2; j++)
                {
                    int dist = Math.abs(r[i] - r[j]) + Math.abs(c[i] - c[j]);
                    if(dist <= 1000)
                    {
                        list.get(i).add(j);
                        list.get(j).add(i);
                    }
                }
            }

            if(dfs(0))
                sb.append("happy\n");
            else
                sb.append("sad\n");
        }

        System.out.print(sb.toString());
    }
}
