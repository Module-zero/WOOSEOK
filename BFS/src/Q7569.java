/*
토마토

https://www.acmicpc.net/problem/7569
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
 * Date: 2021-01-21
 * Time: 오후 5:15
 */

public class Q7569
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][][] ary = new int[101][101][101];
        Queue<int[]> queue = new LinkedList<>();
        for(int h=0; h<H; h++)
        {
            for(int i=0; i<N; i++)
            {
                st = new StringTokenizer(br.readLine());

                for(int j=0; j<M; j++)
                {
                    ary[h][i][j] = Integer.parseInt(st.nextToken());
                    if(ary[h][i][j] == 1)
                        queue.add(new int[]{h, i, j, 0});
                }
            }
        }

        int[] dr = {-1, 0, 0, 1, 0, 0};
        int[] dc = {0, -1, 1, 0, 0, 0};
        int[] dh = {0, 0, 0, 0, -1, 1};

        int max = Integer.MIN_VALUE;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            max = Integer.max(tmp[3], max);

            for(int k=0; k<6; k++)
            {
                int newH = tmp[0] + dh[k];
                if(newH < 0 || newH >= H)
                    continue;

                int newR = tmp[1] + dr[k];
                if(newR < 0 || newR >= N)
                    continue;

                int newC = tmp[2] + dc[k];
                if(newC < 0 || newC >= M)
                    continue;

                if(ary[newH][newR][newC] != 0)
                    continue;

                ary[newH][newR][newC] = 1;
                queue.add(new int[]{newH, newR, newC, tmp[3]+1});
            }
        }

        for(int h=0; h<H; h++)
        {
            for(int r=0; r<N; r++)
            {
                for(int c=0; c<M; c++)
                {
                    if(ary[h][r][c] == 0)
                    {
                        System.out.println(-1);
                        return;
                    }
                }
            }
        }

        System.out.println(max);
    }
}
