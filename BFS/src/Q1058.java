/*
친구

https://www.acmicpc.net/problem/1058
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-11
 * Time: 오후 7:06
 */

public class Q1058
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        boolean[][] ary = new boolean[51][51];
        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            int len = str.length();
            for(int j=1; j<=len; j++)
            {
                if(str.charAt(j - 1) == 'Y')
                    ary[i][j] = true;
            }
        }

        int[] cnt = new int[51];
        Queue<Integer> queue = new LinkedList<>();
        for(int i=1; i<=N; i++)
        {
            boolean[] check = new boolean[51];
            check[i] = true;

            int count = 0;
            for(int j=1; j<=N; j++)
            {
                if(i == j)
                    continue;

                if(ary[i][j])
                {
                    queue.add(j);
                    check[j] = true;
                    count++;
                }
            }

            while(!queue.isEmpty())
            {
                int tmp = queue.poll();

                for(int k=1; k<=N; k++)
                {
                    if(check[k])
                        continue;

                    if(ary[tmp][k])
                    {
                        check[k] = true;
                        count++;
                    }
                }
            }

            cnt[i] = count;
        }

        int ans = Integer.MIN_VALUE;
        for(int i=1; i<=N; i++)
            ans = Integer.max(ans, cnt[i]);

        System.out.println(ans);
    }
}
