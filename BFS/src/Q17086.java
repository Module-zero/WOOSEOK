/*
아기 상어 2

https://www.acmicpc.net/problem/17086
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
 * Date: 2020-11-16
 * Time: 오후 7:10
 */

public class Q17086
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        // 거리
        int[][] dist = new int[51][51];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                dist[i][j] = -1;
        }

        int[][] ary = new int[51][51];
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(ary[i][j] == 1)
                {
                    queue.add(new int[]{i, j});
                    dist[i][j] = 0;
                }
            }
        }

        int max = 0;

        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<9; i++)
            {
                int newRow = tmp[0] + dr[i];
                if(newRow < 0 || newRow >= N)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 0 || newCol >= M)
                    continue;

                // 이미 들렀으면 다음 방향
                if(dist[newRow][newCol] != -1)
                    continue;

                queue.add(new int[]{newRow, newCol});
                dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
                if(dist[newRow][newCol] > max)
                    max = dist[newRow][newCol];
            }
        }

        System.out.println(max);
    }
}
