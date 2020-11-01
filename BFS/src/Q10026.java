/*
적록색약

https://www.acmicpc.net/problem/10026
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-01
 * Time: 오전 12:38
 */

public class Q10026
{
    static int N;
    static char[][] ary = new char[100][100];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static StringBuilder sb = new StringBuilder();

    public static void bfs(boolean isBlind)
    {
        int[][] group = new int[100][100];
        Queue<int[]> queue = new LinkedList<>();
        int gCnt = 0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(group[i][j] == 0)
                {
                    queue.add(new int[]{i, j});
                    gCnt++;
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
                        if(newCol < 0 || newCol >= N)
                            continue;

                        // 아직 들르지 않은 칸이면 전진
                        if(group[newRow][newCol] == 0)
                        {
                            // 적록색약이 아니면
                            if(!isBlind)
                            {
                                // 같은 색일때만 전진
                                if(ary[tmp[0]][tmp[1]] == ary[newRow][newCol])
                                {
                                    group[newRow][newCol] = gCnt;
                                    queue.add(new int[]{newRow, newCol});
                                }
                            }
                            // 적록색약이면
                            else
                            {
                                // R이랑 G를 같게 본다.
                                boolean isSame = false;

                                if(ary[tmp[0]][tmp[1]] == ary[newRow][newCol])
                                    isSame = true;
                                else if(ary[tmp[0]][tmp[1]] == 'R' && ary[newRow][newCol] == 'G')
                                    isSame = true;
                                else if(ary[tmp[0]][tmp[1]] == 'G' && ary[newRow][newCol] == 'R')
                                    isSame = true;

                                if(isSame)
                                {
                                    group[newRow][newCol] = gCnt;
                                    queue.add(new int[]{newRow, newCol});
                                }
                            }
                        }
                    }
                }
            }
        }

        sb.append(gCnt + " ");
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j);
        }

        bfs(false);
        bfs(true);

        System.out.println(sb.toString());
    }
}
