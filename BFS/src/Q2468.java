/*
안전 영역

https://www.acmicpc.net/problem/2468
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
 * Date: 2021-01-22
 * Time: 오후 11:27
 */

public class Q2468
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int max = Integer.MIN_VALUE;
        int[][] ary = new int[101][101];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                if(max < ary[i][j])
                    max = ary[i][j];
            }
        }

        // 아무 지역도 잠기지 않았을 경우 영역의 수는 1
        int ans = 1;
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        for(int rain=1; rain<max; rain++)
        {
            Queue<int[]> queue = new LinkedList<>();
            int[][] group = new int[101][101];
            int gCnt = 0;

            for(int r=0; r<N; r++)
            {
                for(int c=0; c<N; c++)
                {
                    if(ary[r][c] > rain && group[r][c] == 0)
                    {
                        queue.add(new int[]{r, c});
                        group[r][c] = ++gCnt;

                        while(!queue.isEmpty())
                        {
                            int[] tmp = queue.poll();
                            for(int k=0; k<4; k++)
                            {
                                int newR = tmp[0] + dr[k];
                                if(newR < 0 || newR >= N)
                                    continue;

                                int newC = tmp[1] + dc[k];
                                if(newC < 0 || newC >= N)
                                    continue;

                                if(ary[newR][newC] <= rain || group[newR][newC] != 0)
                                    continue;

                                group[newR][newC] = gCnt;
                                queue.add(new int[]{newR, newC});
                            }
                        }
                    }
                }
            }

            ans = Integer.max(ans, gCnt);
        }

        System.out.println(ans);
    }
}
