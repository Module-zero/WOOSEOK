/*
웜홀

https://www.acmicpc.net/problem/1865
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-06
 * Time: 오후 10:53
 */

public class Q1865
{
    static ArrayList<int[]>[] list;
    static int N;
    static boolean[] check;

    public static boolean dfs(int start, int cur, int time)
    {
        check[cur] = true;

        if(start == cur)
        {
            if(time < 0)
                return true;
            else
                return false;
        }

        int size = list[cur].size();
        for(int i=0; i<size; i++)
        {
            int[] next = list[cur].get(i);

            if(!check[next[0]])
            {
                check[next[0]] = true;
                if(dfs(start, next[0], time + next[1]))
                    return true;
            }
            else if(next[0] == start && time + next[1] < 0)
                return true;
        }

        return false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int TC = Integer.parseInt(br.readLine());
        while(TC-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());

            list = new ArrayList[501];
            for(int i=0; i<=500; i++)
                list[i] = new ArrayList<>();

            for(int i=0; i<M; i++)
            {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                list[S].add(new int[]{E, T});
                list[E].add(new int[]{S, T});
            }

            for(int i=0; i<W; i++)
            {
                st = new StringTokenizer(br.readLine());

                int S = Integer.parseInt(st.nextToken());
                int E = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());

                list[S].add(new int[]{E, -T});
            }

            boolean isOk = false;
            for(int i=1; i<=N; i++)
            {
                int size = list[i].size();

                if(size > 0)
                {
                    check = new boolean[501];
                    check[i] = true;

                    for(int j=0; j<size; j++)
                    {
                        int[] next = list[i].get(j);

                        if(dfs(i, next[0], next[1]))
                        {
                            isOk = true;
                            break;
                        }
                    }

                    if(isOk)
                        break;
                }
            }

            if(isOk)
                sb.append("YES\n");
            else
                sb.append("NO\n");
        }

        System.out.print(sb.toString());
    }
}
