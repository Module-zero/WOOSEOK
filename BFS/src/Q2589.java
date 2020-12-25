/*
보물섬

https://www.acmicpc.net/problem/2589
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
 * Time: 오후 8:31
 */

public class Q2589
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] ary = new char[51][51];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
                ary[i][j] = str.charAt(j);
        }

        int ans = 0;
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                // 길이고, 아직 탐색하지 않음
                if(ary[i][j] == 'L')
                {
                    queue.add(new int[]{i, j, 0});
                    boolean[][] check = new boolean[51][51];
                    check[i][j] = true;
                    // 이어진 길 탐색
                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int k=0; k<4; k++)
                        {
                            int newR = tmp[0] + dr[k];
                            if(newR < 0 || newR >= R)
                                continue;

                            int newC = tmp[1] + dc[k];
                            if(newC < 0 || newC >= C)
                                continue;

                            if(ary[newR][newC] == 'W' || check[newR][newC])
                                continue;

                            queue.add(new int[]{newR, newC, tmp[2]+1});
                            check[newR][newC] = true;
                            if(tmp[2] + 1 > ans)
                                ans = tmp[2] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
