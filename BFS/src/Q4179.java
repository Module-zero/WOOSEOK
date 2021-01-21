/*
불!

https://www.acmicpc.net/problem/4179
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
 * Date: 2021-01-05
 * Time: 오전 11:43
 */

public class Q4179
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] ary = new char[1001][1001];
        Queue<int[]> jihun = new LinkedList<>();
        Queue<int[]> fire = new LinkedList<>();
        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
            {
                ary[i][j] = str.charAt(j);
                if(ary[i][j] == 'J')
                    jihun.add(new int[]{i, j});
                else if(ary[i][j] == 'F')
                    fire.add(new int[]{i, j});
            }
        }

        int[][] check = new int[1001][1001];
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
                check[i][j] = -1;
        }
        int[] jihunLocation = jihun.peek();
        check[jihunLocation[0]][jihunLocation[1]] = 0;

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        while(true)
        {
            int fireSize = fire.size();
            for(int k=0; k<fireSize; k++)
            {
                int[] tmp = fire.poll();

                for(int i=0; i<4; i++)
                {
                    int newR = tmp[0] + dr[i];
                    if(newR < 0 || newR >= R)
                        continue;

                    int newC = tmp[1] + dc[i];
                    if(newC < 0 || newC >= C)
                        continue;

                    if(ary[newR][newC] == '#' || ary[newR][newC] == 'F')
                        continue;

                    ary[newR][newC] = 'F';
                    fire.add(new int[]{newR, newC});
                }
            }

            int jihunSize = jihun.size();
            boolean move = false;
            for(int k=0; k<jihunSize; k++)
            {
                int[] tmp = jihun.poll();

                for(int i=0; i<4; i++)
                {
                    int newR = tmp[0] + dr[i];
                    if(newR < 0 || newR >= R)
                    {
                        System.out.println(check[tmp[0]][tmp[1]] + 1);
                        return;
                    }

                    int newC = tmp[1] + dc[i];
                    if(newC < 0 || newC >= C)
                    {
                        System.out.println(check[tmp[0]][tmp[1]] + 1);
                        return;
                    }

                    if(ary[newR][newC] == '.' && check[newR][newC] == -1)
                    {
                        check[newR][newC] = check[tmp[0]][tmp[1]] + 1;
                        jihun.add(new int[]{newR, newC});
                        move = true;
                    }
                }
            }

            if(!move)
            {
                System.out.println("IMPOSSIBLE");
                return;
            }
        }
    }
}
