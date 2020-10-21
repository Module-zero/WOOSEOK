/*
섬의 개수

https://www.acmicpc.net/problem/4963
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-21
 * Time: 오후 2:54
 */

public class Q4963
{
    static int w;
    static int h;
    static int[][] map;
    static boolean[][] check;
    static int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
    static int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

    public static void dfs(int row, int col, int cnt)
    {
        check[row][col] = true;

        for(int i=0; i<=8; i++)
        {
            int newRow = row+dr[i];
            int newCol = col+dc[i];

            if(map[newRow][newCol] == 1 && !check[newRow][newCol])
                dfs(newRow, newCol, cnt);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0)
                break;

            map = new int[h+2][w+2];
            check = new boolean[h+2][w+2];

            for (int i=1; i<=h; i++)
            {
                st = new StringTokenizer(br.readLine());

                for(int j=1; j<=w; j++)
                    map[i][j] = Integer.parseInt(st.nextToken());
            }

            int cnt = 0;
            for(int i=1; i<=h; i++)
            {
                for(int j=1; j<=w; j++)
                {
                    if(map[i][j] == 1 && !check[i][j])
                        dfs(i, j, cnt++);
                }
            }

            sb.append(cnt + "\n");
        }

        System.out.print(sb.toString());
    }
}
