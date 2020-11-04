/*
연구소

https://www.acmicpc.net/problem/14502
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
 * Date: 2020-10-28
 * Time: 오후 3:25
 */

public class Q14502
{
    static int N;
    static int M;
    static int max = Integer.MIN_VALUE;

    static class Map
    {
        int row;
        int col;
        int[][] map;
        boolean[][] check;
        int cnt;

        public Map(int row, int col, int[][] map, int cnt)
        {
            this.row = row;
            this.col = col;
            this.map = new int[8][8];
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                    this.map[i][j] = map[i][j];
            }

            this.check = new boolean[8][8];
            this.cnt = cnt;
        }

        public void setWall(int i, int j)
        {
            map[i][j] = 1;
            cnt++;
        }
    }

    public static void virus(int[][] tMap)
    {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[8][8];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int[][] map = new int[8][8];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                map[i][j] = tMap[i][j];
            }
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 바이러스일 경우 퍼트린다.
                if(map[i][j] == 2 && !check[i][j])
                {
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int k=0; k<4; k++)
            {
                int newRow = tmp[0] + dr[k];
                if(newRow < 0 || newRow >= N)
                    continue;

                int newCol = tmp[1] + dc[k];
                if(newCol < 0 || newCol >= M)
                    continue;

                // 벽을 만날 경우 진행할 수 없다.
                if(map[newRow][newCol] == 1)
                    continue;
                else
                {
                    if (!check[newRow][newCol])
                    {
                        map[newRow][newCol] = 2;
                        check[newRow][newCol] = true;
                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }
        }

        int cnt = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                System.out.print(map[i][j] + " ");
                if(map[i][j] == 0)
                    cnt++;
            }

            System.out.println();
        }
        System.out.println(cnt);

        if(max < cnt)
            max = cnt;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[8][8];

        // 연구소 입력
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<Map> queue = new LinkedList<>();
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 길일 경우
                if(ary[i][j] == 0)
                {
                    // [0], [1] : index, [2] : 벽을 놓은 횟수
                    queue.add(new Map(i, j, ary, 0));
                    boolean[][][] check = new boolean[8][8][2];
                    check[i][j][0] = true;

                    while(!queue.isEmpty())
                    {
                         Map tmp = queue.poll();

                        for(int k=0; k<4; k++)
                        {
                            // 인덱스 검사
                            int newRow = tmp.row + dr[k];
                            if(newRow < 0 || newRow >= N)
                                continue;

                            int newCol = tmp.col + dc[k];
                            if(newCol < 0 || newCol >= M)
                                continue;

                            if(tmp.map[newRow][newCol] == 0)
                            {
                                if(!check[newRow][newCol][0])
                                {
                                    // 벽을 세우지 않을 경우
                                    queue.add(new Map(newRow, newCol, tmp.map, tmp.cnt));
                                    check[newRow][newCol][0] = true;
                                }

                                if(!check[newRow][newCol][1])
                                {
                                    // 벽을 세울 경우
                                    tmp.setWall(newRow, newCol);
                                    // 벽을 3개 세운 경우 탐색
                                    if (tmp.cnt == 3)
                                    {
                                        virus(tmp.map);
                                        continue;
                                    }

                                    queue.add(new Map(newRow, newCol, tmp.map, tmp.cnt + 1));
                                    check[newRow][newCol][1] = true;
                                }
                            }
                        }
                    }
                }
            }
        }

        System.out.println(max);
    }
}
