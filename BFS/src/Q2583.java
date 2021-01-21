/*
영역 구하기

https://www.acmicpc.net/problem/2583
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-21
 * Time: 오후 4:59
 */

public class Q2583
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] ary = new int[101][101];

        for(int i=0; i<K; i++)
        {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int r=y; r<y2; r++)
            {
                for(int c=x; c<x2; c++)
                    ary[r][c] = 1;
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int[][] group = new int[101][101];
        int gCnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        ArrayList<Integer> area = new ArrayList<>();

        for(int i=0; i<M; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(ary[i][j] == 0 && group[i][j] == 0)
                {
                    int cnt = 1;
                    group[i][j] = ++gCnt;
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int k=0; k<4; k++)
                        {
                            int newR = tmp[0] + dr[k];
                            if(newR < 0 || newR >= M)
                                continue;

                            int newC = tmp[1] + dc[k];
                            if(newC < 0 || newC >= N)
                                continue;

                            if(ary[newR][newC] == 1 || group[newR][newC] != 0)
                                continue;

                            group[newR][newC] = gCnt;
                            queue.add(new int[]{newR, newC});
                            cnt++;
                        }
                    }

                    area.add(cnt);
                }
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(gCnt).append('\n');
        Collections.sort(area);
        int size = area.size();
        for(int i=0; i<size; i++)
            sb.append(area.get(i)).append(' ');

        System.out.println(sb.toString());
    }
}
