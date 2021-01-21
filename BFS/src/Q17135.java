/*
캐슬 디펜스

https://www.acmicpc.net/problem/17135
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
 * Date: 2021-01-03
 * Time: 오후 7:12
 */

public class Q17135
{
    static int N;
    static int M;
    static int D;
    static int[][] ary = new int[16][16];
    // 좌/하/우
    static int[] dr = {0, -1, 0};
    static int[] dc = {-1, 0, 1};
    static int max = Integer.MIN_VALUE;

    public static boolean isEnd(int[][] map)
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(map[i][j] == 1)
                    return false;
            }
        }

        return true;
    }

    public static void swap(int[][] map)
    {
        for(int i=N-2; i>=0; i--)
        {
            for(int j=0; j<M; j++)
            {
                map[i+1][j] = map[i][j];
                map[i][j] = 0;
            }
        }
    }

    public static int[] bfs(int c, int[][] map)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, c});
        boolean[][] check = new boolean[16][16];

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int k=0; k<3; k++)
            {
                int newR = tmp[0] + dr[k];
                if(newR < 0 || newR >= N)
                    continue;

                int newC = tmp[1] + dc[k];
                if(newC < 0 || newC >= M)
                    continue;

                if(check[newR][newC])
                    continue;

                if(map[newR][newC] == 1)
                    return new int[]{newR, newC};

                // 거리 제한 D
                if(Math.abs(newR - tmp[0]) + Math.abs(newC - tmp[1]) >= D)
                    break;

                check[newR][newC] = true;
                queue.add(new int[]{newR, newC});
            }
        }

        return null;
    }

    public static void foo()
    {
        for(int c1=0; c1<M-2; c1++)
        {
            for(int c2=c1+1; c2<M-1; c2++)
            {
                for(int c3=c2+1; c3<M; c3++)
                {
                    int[][] map = new int[16][16];
                    for(int i=0; i<N; i++)
                    {
                        for(int j=0; j<M; j++)
                            map[i][j] = ary[i][j];
                    }

                    int cnt = 0;
                    while(!isEnd(map))
                    {
                        int[] tmp1 = bfs(c1, map);
                        int[] tmp2 = bfs(c2, map);
                        int[] tmp3 = bfs(c3, map);

                        if(tmp1 != null)
                        {
                            map[tmp1[0]][tmp1[1]] = 0;
                            cnt++;
                        }
                        if(tmp2 != null && map[tmp2[0]][tmp2[1]] != 0)
                        {
                            map[tmp2[0]][tmp2[1]] = 0;
                            cnt++;
                        }
                        if(tmp3 != null && map[tmp3[0]][tmp3[1]] != 0)
                        {
                            map[tmp3[0]][tmp3[1]] = 0;
                            cnt++;
                        }

                        swap(map);
                    }

                    max = Integer.max(max, cnt);
                }
            }
        }
    }

    public static void print(int[][] map)
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        foo();

        System.out.println(max);
    }
}
