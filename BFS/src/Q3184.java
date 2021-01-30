/*
양

https://www.acmicpc.net/problem/3184
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
 * Date: 2021-01-30
 * Time: 오후 11:08
 */

public class Q3184
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] ary = new char[251][251];
        int sheep = 0;
        int wolf = 0;
        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
            {
                ary[i][j] = str.charAt(j);
                if(ary[i][j] == 'o')
                    sheep++;
                else if(ary[i][j] == 'v')
                    wolf++;
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[251][251];
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(ary[i][j] != '#' && !check[i][j])
                {
                    queue.add(new int[]{i, j});
                    check[i][j] = true;

                    int s = 0;
                    int w = 0;
                    if(ary[i][j] == 'o')
                        s++;
                    else if(ary[i][j] == 'v')
                        w++;

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

                            if(ary[newR][newC] == '#' || check[newR][newC])
                                continue;

                            if(ary[newR][newC] == 'o')
                                s++;
                            else if(ary[newR][newC] == 'v')
                                w++;

                            queue.add(new int[]{newR, newC});
                            check[newR][newC] = true;
                        }
                    }

                    if(s > w)
                        wolf -= w;
                    else
                        sheep -= s;
                }
            }
        }

        System.out.println(sheep + " " + wolf);
    }
}
