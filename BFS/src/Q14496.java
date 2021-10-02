/*
그대, 그머가 되어

https://www.acmicpc.net/problem/14496
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-04-27
 * Time: 오후 2:13
 */

public class Q14496
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Integer>[] list = new ArrayList[1001];
        int[] check = new int[1001];
        for(int i=1; i<=N; i++)
        {
            list[i] = new ArrayList<>();
            check[i] = -1;
        }

        while(M-- > 0)
        {
            st = new StringTokenizer(br.readLine());

            int q = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            list[q].add(p);
            list[p].add(q);
        }

        Queue<Integer> queue = new LinkedList<>();
        check[a] = 0;
        queue.add(a);
        while(!queue.isEmpty())
        {
            int tmp = queue.poll();

            for(int next : list[tmp])
            {
                if(check[next] != -1)
                    continue;

                check[next] = check[tmp] + 1;
                queue.add(next);
            }
        }

        System.out.println(check[b]);
    }
}
