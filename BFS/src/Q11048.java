/*
이동하기

https://www.acmicpc.net/problem/11048
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 3:44
 */

public class Q11048
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][1001];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {1, 0};
        int[] dc = {0, 1};

        Queue<int[]> queue = new LinkedList<>();
        int[][] candy = new int[1001][1001];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
                candy[i][j] = -1;
        }

        queue.add(new int[]{1, 1});
        candy[1][1] = ary[1][1];

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<2; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR < 1 || newR > N)
                    continue;

                int newC = tmp[1] + dc[i];
                if(newC < 1 || newC > M)
                    continue;

                if(candy[newR][newC] == -1 || candy[tmp[0]][tmp[1]] + ary[newR][newC] > candy[newR][newC])
                {
                    candy[newR][newC] = candy[tmp[0]][tmp[1]] + ary[newR][newC];
                    queue.add(new int[]{newR, newC});
                }
            }
        }

        System.out.println(candy[N][M]);
    }
}
