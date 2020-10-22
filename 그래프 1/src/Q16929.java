/*
Two Dots

https://www.acmicpc.net/problem/16929
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오전 11:18
 */

public class Q16929
{
    static int N;
    static int M;
    static char[][] ary;
    static int[][] dist;
    static boolean[][] check;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static boolean isCycle = false;

    public static void dfs(int row, int col, int cnt)
    {
        // 한 번 방문했던 곳이면 사이클인지 확인하고 종료
        if(check[row][col])
        {
            if (cnt - dist[row][col] >= 4)
                isCycle = true;

            return;
        }

        check[row][col] = true;
        dist[row][col] = cnt;

        // 4방향 탐색
        for(int i=0; i<4; i++)
        {
            int newRow = row + dr[i];
            int newCol= col + dc[i];

            // 게임판의 크기를 벗어나면 다음 방향 탐색
            if(newRow < 0 || newRow >= N)
                continue;
            if(newCol < 0 || newCol >= M)
                continue;

            // 같은 문자면 탐색
            if(ary[newRow][newCol] == ary[row][col])
            {
                dfs(newRow, newCol, cnt + 1);
            }

            // 사이클을 찾았으면 종료
            if(isCycle)
                return;
        }

        check[row][col] = false;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        ary = new char[N][M];
        // 시작점으로부터의 거리를 기록
        dist = new int[N][M];
        check = new boolean[N][M];

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 첫 번째부터 dfs 탐색 시작
                dfs(i, j, 0);
                check[i][j] = false;

                if(isCycle)
                    break;
            }

            if(isCycle)
                break;
        }

        StringBuilder sb = new StringBuilder();

        if(isCycle)
            sb.append("Yes");
        else
            sb.append("No");

        System.out.println(sb.toString());
    }
}
