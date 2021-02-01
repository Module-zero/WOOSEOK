/*
음식물 피하기

https://www.acmicpc.net/problem/1743
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
 * Date: 2021-02-01
 * Time: 오후 6:51
 */

public class Q1743
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            ary[r][c] = 1;
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        int[][] group = new int[101][101];
        int gCnt = 0;
        int max = 0;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                if(ary[i][j] == 1 && group[i][j] == 0)
                {
                    int area = 1;
                    group[i][j] = ++gCnt;

                    queue.add(new int[]{i, j});
                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int k=0; k<4; k++)
                        {
                            int newR = tmp[0] + dr[k];
                            if(newR < 1 || newR > N)
                                continue;
                            int newC = tmp[1] + dc[k];
                            if(newC < 1 || newC > M)
                                continue;

                            if(ary[newR][newC] != 1 || group[newR][newC] != 0)
                                continue;

                            group[newR][newC] = gCnt;
                            queue.add(new int[]{newR, newC});
                            area++;
                        }
                    }

                    max = Integer.max(max, area);
                }
            }
        }

        System.out.println(max);
    }
}
