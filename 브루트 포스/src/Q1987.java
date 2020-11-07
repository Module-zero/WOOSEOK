/*
알파벳

https://www.acmicpc.net/problem/1987
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 10:17
 */

public class Q1987
{
    static int R;
    static int C;
    static char[][] ary = new char[21][21];
    static boolean[] check = new boolean[26];
    static boolean[][] visited = new boolean[21][21];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int max = Integer.MIN_VALUE;

    public static void foo(int row, int col, int cnt)
    {
        visited[row][col] = true;
        check[ary[row][col] - 'A'] = true;
        if(max < cnt)
            max = cnt;

        for(int i=0; i<4; i++)
        {
            int newRow = row + dr[i];
            if(newRow < 0 || newRow >= R)
                continue;

            int newCol = col + dc[i];
            if(newCol < 0 || newCol >= C)
                continue;

            int num = ary[newRow][newCol] - 'A';
            // 들르지 않았고 나오지 않은 알파벳이면 전진한다.
            if(!visited[newRow][newCol] && !check[num])
                foo(newRow, newCol, cnt + 1);
        }

        visited[row][col] = false;
        check[ary[row][col] - 'A'] = false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
                ary[i][j] = str.charAt(j);
        }

        foo(0, 0, 1);

        System.out.println(max);
    }
}
