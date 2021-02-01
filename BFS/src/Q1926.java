/*
그림

https://www.acmicpc.net/problem/1926
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
 * Time: 오후 6:04
 */

public class Q1926
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] ary = new int[501][501];
        for(int i=0; i<n; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<m; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        int[][] group = new int[501][501];
        int gCnt = 0;
        int max = 0;
        for(int i=0; i<n; i++)
        {
            for(int j=0; j<m; j++)
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
                            if(newR < 0 || newR >= n)
                                continue;

                            int newC = tmp[1] + dc[k];
                            if(newC < 0 || newC >= m)
                                continue;

                            if(ary[newR][newC] == 0 || group[newR][newC] != 0)
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

        StringBuffer sb = new StringBuffer();
        sb.append(gCnt).append('\n').append(max);

        System.out.println(sb.toString());
    }
}
