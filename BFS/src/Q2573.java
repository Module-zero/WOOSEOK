/*
빙산

https://www.acmicpc.net/problem/2573
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
 * Date: 2020-12-25
 * Time: 오후 6:02
 */

public class Q2573
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[301][301];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        while(true)
        {
            // 그룹을 매긴다.
            int[][] group = new int[301][301];
            int gNum = 0;
            int[] gCnt = new int[9000];
            Queue<int[]> queue = new LinkedList<>();
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(ary[i][j] != 0 && group[i][j] == 0)
                    {
                        queue.add(new int[]{i, j});
                        group[i][j] = ++gNum;
                        gCnt[gNum]++;

                        while(!queue.isEmpty())
                        {
                            int[] tmp = queue.poll();

                            for(int k=0; k<4; k++)
                            {
                                int newR = tmp[0] + dr[k];
                                if(newR < 0 || newR >= N)
                                    continue;

                                int newC = tmp[1] + dc[k];
                                if(newC < 0 || newC >= M)
                                    continue;

                                if(ary[newR][newC] == 0 || group[newR][newC] != 0)
                                    continue;

                                group[newR][newC] = gNum;
                                gCnt[gNum]++;
                                queue.add(new int[]{newR, newC});
                            }
                        }
                    }
                }
            }

            if(gCnt[1] == 0)
            {
                ans = 0;
                break;
            }
            else if(gCnt[2] > 0)
                break;

            // 빙하를 녹인다.
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(ary[i][j] != 0)
                    {
                        int cnt = 0;
                        int g = group[i][j];

                        for(int k=0; k<4; k++)
                        {
                            int newR = i + dr[k];
                            if(newR < 0 || newR >= N)
                                continue;
                            int newC = j + dc[k];
                            if(newC < 0 || newC >= M)
                                continue;

                            if(group[newR][newC] != g)
                                cnt++;
                        }

                        ary[i][j] -= cnt;
                        if(ary[i][j] < 0)
                            ary[i][j] = 0;
                    }
                }
            }

            ans++;
        }

        System.out.println(ans);
    }
}
