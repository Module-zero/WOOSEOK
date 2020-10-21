/*
단지번호붙이기

https://www.acmicpc.net/problem/2667
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-21
 * Time: 오후 1:53
 */

public class Q2667
{
    static int N;
    static int[][] ary = new int[30][30];
    static boolean[][] check = new boolean[30][30];
    static int[] ans = new int[500];
    static int[] dc = {-1, 0, 0, 1};
    static int[] dr = {0, -1, 1, 0};

    public static void dfs(int col, int row, int cnt)
    {
        // 방문했음을 표시
        check[col][row] = true;
        // 카운트 1 증가
        ans[cnt]++;

        for(int i=0; i<4; i++)
        {
            int newCol = col + dc[i];
            int newRow = row + dr[i];

            // 방문하지 않은 인접한 점이 있다면 방문
            if(ary[newCol][newRow] != 0 && !check[newCol][newRow])
                dfs(newCol, newRow, cnt);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(String.valueOf(str.charAt(j-1)));
        }

        int cnt = 0;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=N; j++)
            {
                if (ary[i][j] != 0 && !check[i][j])
                    dfs(i, j, ++cnt);
            }
        }

        StringBuilder sb = new StringBuilder();

        int i = 1;
        sb.append(cnt + "\n");

        Arrays.sort(ans, 1, cnt+1);

        while(ans[i] != 0)
        {
            sb.append(ans[i] + "\n");
            i++;
        }

        System.out.print(sb.toString());
    }
}
