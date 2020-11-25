/*
Baaaaaaaaaduk2 (Easy)

https://www.acmicpc.net/problem/16988
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
 * Date: 2020-11-25
 * Time: 오후 3:14
 */

public class Q16988
{
    static int N;
    static int M;
    static int[][] ary = new int[21][21];
    static boolean[][] check;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int max = Integer.MIN_VALUE;

    public static void bfs()
    {
        Queue<int[]> queue = new LinkedList<>();
        check = new boolean[21][21];

        int ans = 0;

        for(int r=0; r<N; r++)
        {
            for(int c=0; c<M; c++)
            {
                if(ary[r][c] == 2 && !check[r][c])
                {
                    int cnt = 1;
                    boolean esc = false;
                    queue.add(new int[]{r, c});
                    check[r][c] = true;

                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int i=0; i<4; i++)
                        {
                            int newRow = tmp[0] + dr[i];
                            if(newRow < 0 || newRow >= N)
                                continue;

                            int newCol = tmp[1] + dc[i];
                            if(newCol < 0 || newCol >= M)
                                continue;

                            // 빈 공간이 있으면 죽일 수 없음
                            // 같은 그룹은 모두 죽일 수 없는 것이므로 같은 그룹이 모두 진행될 때까지 종료하지 않는다.
                            if(ary[newRow][newCol] == 0)
                                esc = true;

                            if(check[newRow][newCol])
                                continue;

                            // 인접한 상대 돌이면(같은 그룹이면) 큐에 넣는다.
                            else if(ary[newRow][newCol] == 2)
                            {
                                queue.add(new int[]{newRow, newCol});
                                cnt++;
                            }

                            check[newRow][newCol] = true;
                        }
                    }

                    if(esc)
                        continue;
                    else
                        ans += cnt;
                }
            }
        }

        if(ans > max)
            max = ans;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int r1=0; r1<N; r1++)
        {
            for(int c1=0; c1<M; c1++)
            {
                if(ary[r1][c1] == 0)
                {
                    // 돌 하나 놓음
                    ary[r1][c1] = 1;

                    for(int r2=0; r2<N; r2++)
                    {
                        for(int c2=0; c2<M; c2++)
                        {
                            if(ary[r2][c2] == 0)
                            {
                                // 돌 두개 놓음
                                ary[r2][c2] = 1;

                                bfs();

                                // 두 번째 돌 원상복귀
                                ary[r2][c2] = 0;
                            }
                        }
                    }

                    // 첫 번째 돌 원상복귀
                    ary[r1][c1] = 0;
                }
            }
        }

        System.out.println(max);
    }
}
