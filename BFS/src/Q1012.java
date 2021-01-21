/*
유기농 배추

https://www.acmicpc.net/problem/1012
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
 * Date: 2021-01-21
 * Time: 오후 4:52
 */

public class Q1012
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        StringBuffer sb = new StringBuffer();
        while(T-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int M = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());

            int[][] ary = new int[51][51];
            for(int i=0; i<K; i++)
            {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());

                ary[y][x] = 1;
            }

            int cnt = 0;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] check = new boolean[51][51];
            for(int r=0; r<N; r++)
            {
                for(int c=0; c<M; c++)
                {
                    if(ary[r][c] == 1 && !check[r][c])
                    {
                        cnt++;
                        queue.add(new int[]{r, c});
                        check[r][c] = true;

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

                                if(check[newR][newC] || ary[newR][newC] == 0)
                                    continue;

                                queue.add(new int[]{newR, newC});
                                check[newR][newC] = true;
                            }
                        }
                    }
                }
            }

            sb.append(cnt).append('\n');
        }

        System.out.print(sb.toString());
    }
}
