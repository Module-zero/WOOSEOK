/*
봄버맨

https://www.acmicpc.net/problem/16918
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
 * Date: 2021-01-01
 * Time: 오후 10:44
 */

public class Q16918
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        char[][] ary = new char[201][201];
        int[][] bomb = new int[201][201];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
                ary[i][j] = str.charAt(j);
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int t=2; t<=N; t++)
        {
            if(t % 2 == 0)
            {
                for(int i=0; i<R; i++)
                {
                    for(int j=0; j<C; j++)
                    {
                        if(ary[i][j] == '.')
                        {
                            ary[i][j] = 'O';
                            bomb[i][j] = t;
                        }
                    }
                }
            }
            else
            {
                for(int i=0; i<R; i++)
                {
                    for(int j=0; j<C; j++)
                    {
                        if(bomb[i][j] == t-3)
                        {
                            ary[i][j] = '.';

                            for(int k=0; k<4; k++)
                            {
                                int newR = i + dr[k];
                                if(newR < 0 || newR >= R)
                                    continue;

                                int newC = j + dc[k];
                                if(newC < 0 || newC >= C)
                                    continue;

                                ary[newR][newC] = '.';
                            }
                        }
                    }
                }
            }
        }

        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
                sb.append(ary[i][j]);
            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
