/*
치즈

https://www.acmicpc.net/problem/2638
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
 * Date: 2020-12-26
 * Time: 오후 8:48
 */

public class Q2638
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[101][101];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        while(true)
        {
            Queue<int[]> queue = new LinkedList<>();
            int[][] group = new int[101][101];
            int gNum = 0;

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(group[i][j] == 0)
                    {
                        group[i][j] = ++gNum;
                        queue.add(new int[]{i, j});

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

                                if(ary[newR][newC] == ary[tmp[0]][tmp[1]] && group[newR][newC] == 0)
                                {
                                    group[newR][newC] = gNum;
                                    queue.add(new int[]{newR, newC});
                                }
                            }
                        }
                    }
                }
            }

            // 치즈가 다 녹았을 경우
            if(gNum == 1)
                break;

            ans++;
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    if(ary[i][j] == 0)
                        continue;

                    int cnt = 0;
                    for(int k=0; k<4; k++)
                    {
                        int newR = i + dr[k];
                        if(newR < 0 || newR >= N)
                            continue;

                        int newC = j + dc[k];
                        if(newC < 0 || newC >= M)
                            continue;

                        // 공기와 맞닿아있으면 cnt 증가
                        if(group[newR][newC] == 1)
                            cnt++;
                    }

                    // 2변 이상이 공기와 맞닿으면 녹아 없어진다.
                    if(cnt >= 2)
                        ary[i][j] = 0;
                }
            }
        }

        System.out.println(ans);
    }
}
