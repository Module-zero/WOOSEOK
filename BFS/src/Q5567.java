/*
결혼식

https://www.acmicpc.net/problem/5567
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
 * Date: 2021-01-28
 * Time: 오후 7:46
 */

public class Q5567
{

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for(int i=0; i<=n; i++)
            list.add(new ArrayList<>());

        int m = Integer.parseInt(br.readLine());
        for(int i=0; i<m; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list.get(a).add(b);
            list.get(b).add(a);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        boolean[] check = new boolean[501];
        check[1] = true;

        int ans = 0;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            if(tmp[1] == 2)
                continue;

            int size = list.get(tmp[0]).size();
            for(int i=0; i<size; i++)
            {
                int next = list.get(tmp[0]).get(i);
                if(!check[next])
                {
                    check[next] = true;
                    queue.add(new int[]{next, tmp[1] + 1});
                    ans++;
                }
            }
        }

        System.out.println(ans);
    }
}
