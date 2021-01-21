/*
스타트 택시

https://www.acmicpc.net/problem/19238
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
 * Date: 2021-01-05
 * Time: 오후 3:58
 */

public class Q19238
{
    static class Customer
    {
        int startR;
        int startC;
        int endR;
        int endC;
        int distance;

        public Customer(int startR, int startC, int endR, int endC, int distance)
        {
            this.startR = startR;
            this.startC = startC;
            this.endR = endR;
            this.endC = endC;
            this.distance = distance;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int fuel = Integer.parseInt(st.nextToken());

        int[][] map = new int[21][21];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        Queue<int[]> queue = new LinkedList<>();
        int bjR = Integer.parseInt(st.nextToken());
        int bjC = Integer.parseInt(st.nextToken());
        queue.add(new int[]{bjR, bjC});

        int cnt = 2;
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            int sR = Integer.parseInt(st.nextToken());
            int sC = Integer.parseInt(st.nextToken());
            int eR = Integer.parseInt(st.nextToken());
            int eC = Integer.parseInt(st.nextToken());

            map[sR][sC] = cnt++;
            map[eR][eC] = cnt++;
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        // 택시 기준 최단 거리 산출
        int[][] dist = new int[21][21];
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
                dist[i][j] = -1;
        }

        int maxDist = 10000;
        int r = 10000;
        int c = 10000;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            // 가장 가까운 승객을 찾았을 경우 더 멀리 있으면 고려하지 않음
            if(dist[tmp[0]][tmp[1]] >= maxDist)
                continue;

            for(int i=0; i<4; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR < 1 || newR > N)
                    continue;

                int newC = tmp[1] + dc[i];
                if(newC < 1 || newC > N)
                    continue;

                if(map[newR][newC] == 1 || dist[newR][newC] != -1)
                    continue;

                // 승객의 출발점
                if(map[newR][newC] != 0 && map[newR][newC] % 2 == 0)
                {
                    // 최단거리 산정
                    if(dist[tmp[0]][tmp[1]] + 1 < maxDist)
                        maxDist = dist[tmp[0]][tmp[1]] + 1;

                    if(newR < r)
                    {
                        r = newR;
                        c = newC;
                    }
                    else if(newR == r)
                    {
                        if(newC < c)
                        {
                            r = newR;
                            c = newC;
                        }
                    }
                }

                dist[newR][newC] = dist[tmp[0]][tmp[1]] + 1;
                queue.add(new int[]{newR, newC});
            }
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
                System.out.print(dist[i][j] + " ");
            System.out.println();
        }
    }
}
