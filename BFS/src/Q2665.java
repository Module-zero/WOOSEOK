/*
미로만들기

https://www.acmicpc.net/problem/2665
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-05
 * Time: 오전 11:18
 */

public class Q2665
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ary = new int[51][51];

        for(int i=0; i<n; i++)
        {
            String str = br.readLine();

            for(int j=0; j<n; j++)
                ary[i][j] = str.charAt(j) - '0';
        }

        Queue<int[]> queue = new LinkedList<>();
        int[][] check = new int[51][51];
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<n; j++)
                check[i][j] = 10000;
        }

        queue.add(new int[]{0, 0, 0});
        check[0][0] = 0;
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR < 0 || newR >= n)
                    continue;

                int newC = tmp[1] + dc[i];
                if(newC < 0 || newC >= n)
                    continue;

                // 검은 방일 경우
                if(ary[newR][newC] == 0)
                {
                    // 더 많은 방을 부수고 왔으면 스킵
                    if(tmp[2]+1 >= check[newR][newC])
                        continue;

                    queue.add(new int[]{newR, newC, tmp[2]+1});
                    check[newR][newC] = tmp[2]+1;
                }
                // 흰 방일 경우
                else
                {
                    if(tmp[2] >= check[newR][newC])
                        continue;

                    queue.add(new int[]{newR, newC, tmp[2]});
                    check[newR][newC] = tmp[2];
                }
            }
        }

        System.out.println(check[n-1][n-1]);
    }
}
