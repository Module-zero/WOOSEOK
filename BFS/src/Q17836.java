/*
공주님을 구해라!

https://www.acmicpc.net/problem/17836
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
 * Date: 2021-01-07
 * Time: 오후 2:59
 */

public class Q17836
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        int[][][] dist = new int[101][101][2];
        for(int i=1; i<=100; i++)
        {
            for(int j=1; j<=100; j++)
            {
                dist[i][j][0] = -1;
                dist[i][j][1] = -1;
            }
        }

        queue.add(new int[]{1, 1, 0});
        dist[1][1][0] = 0;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            if(dist[tmp[0]][tmp[1]][tmp[2]] > T)
                continue;

            for(int i=0; i<4; i++)
            {
                int newR = tmp[0] + dr[i];
                if(newR <= 0 || newR > N)
                    continue;
                int newC = tmp[1] + dc[i];
                if(newC <= 0 || newC > M)
                    continue;

                if(dist[newR][newC][tmp[2]] > -1)
                    continue;

                if(newR == N && newC == M)
                {
                    System.out.println(dist[tmp[0]][tmp[1]][tmp[2]] + 1);
                    return;
                }

                if(ary[newR][newC] == 2)
                {
                    dist[newR][newC][0] = dist[tmp[0]][tmp[1]][0] + 1;
                    dist[newR][newC][1] = dist[tmp[0]][tmp[1]][0] + 1;
                    queue.add(new int[]{newR, newC, 1});
                }
                else if(ary[newR][newC] == 1)
                {
                    // 그람이 없으면
                    if(tmp[2] == 0)
                        continue;
                    else
                    {
                        dist[newR][newC][tmp[2]] = dist[tmp[0]][tmp[1]][tmp[2]] + 1;
                        queue.add(new int[]{newR, newC, tmp[2]});
                    }
                }
                else
                {
                    dist[newR][newC][tmp[2]] = dist[tmp[0]][tmp[1]][tmp[2]] + 1;
                    queue.add(new int[]{newR, newC, tmp[2]});
                }
            }
        }

        System.out.println("Fail");
    }
}
