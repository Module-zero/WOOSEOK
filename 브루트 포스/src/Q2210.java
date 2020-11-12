/*
숫자판 점프

https://www.acmicpc.net/problem/2210
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오후 2:10
 */

public class Q2210
{
    static int[][] ary = new int[5][5];
    static boolean[] check = new boolean[1000000];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void foo(int index, int row, int col, int sum)
    {
        if(index == 5)
        {
            check[sum] = true;
            return;
        }

        for(int i=0; i<4; i++)
        {
            int newRow = row + dr[i];
            if(newRow < 0 || newRow >= 5)
                continue;

            int newCol = col + dc[i];
            if(newCol < 0 || newCol >= 5)
                continue;

            foo(index+1, newRow, newCol, 10*sum + ary[newRow][newCol]);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<5; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
                foo(0, i, j, ary[i][j]);
        }

        int cnt = 0;
        for(int i=0; i<1000000; i++)
        {
            if (check[i])
                cnt++;
        }

        System.out.println(cnt);
    }
}
