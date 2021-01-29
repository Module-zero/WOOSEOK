/*
효율적인 해킹

https://www.acmicpc.net/problem/1325
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-28
 * Time: 오전 11:26
 */

public class Q1325
{
    static ArrayList<ArrayList<Integer>> list = new ArrayList<>();
    static boolean[] check;
    static int[] cnt = new int[10001];

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for(int i=0; i<=N; i++)
            list.add(new ArrayList<>());

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            list.get(b).add(a);
        }

        int maxCnt = Integer.MIN_VALUE;
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            int cur = 0;
            check = new boolean[10001];

            queue.add(i);
            check[i] = true;
            while(!queue.isEmpty())
            {
                cur++;
                int tmp = queue.poll();

                int size = list.get(tmp).size();
                for(int k=0; k<size; k++)
                {
                    int next = list.get(tmp).get(k);
                    if(!check[next])
                    {
                        check[next] = true;
                        queue.add(next);
                    }
                }
            }

            cnt[i] = cur;
            maxCnt = Integer.max(maxCnt, cur);
        }

        StringBuffer sb = new StringBuffer();

        for(int i=1; i<=N; i++)
        {
            if(cnt[i] == maxCnt)
                sb.append(i).append(' ');
        }

        System.out.println(sb.toString());
    }
}
