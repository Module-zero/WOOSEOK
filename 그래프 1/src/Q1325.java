/*
효율적인 해킹

https://www.acmicpc.net/problem/1325
 */

import java.io.*;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오전 11:26
 */

public class Q1325
{
    static ArrayList<Integer>[] list;
    static int[] cnt = new int[10001];
    static boolean[] check;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        list = new ArrayList[N+1];
        for(int i=0; i<=N; i++)
            list[i] = new ArrayList<>();

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list[a].add(b);
        }

        int maxCnt = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++)
        {
            if(list[i].size() > 0)
            {
                check = new boolean[10001];
                Queue<Integer> queue = new LinkedList<>();

                queue.add(i);
                check[i] = true;

                while(!queue.isEmpty())
                {
                    int tmp = queue.poll();

                    for(int j : list[tmp])
                    {
                        if(!check[j])
                        {
                            check[j] = true;
                            queue.add(j);
                            cnt[j]++;
                        }
                    }
                }
            }
        }

        for(int i=1; i<=N; i++)
        {
            if(maxCnt < cnt[i])
                maxCnt = cnt[i];
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=N; i++)
        {
            if(cnt[i] == maxCnt)
                sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
        br.close();
    }
}
