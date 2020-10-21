/*
미로 탐색

https://www.acmicpc.net/problem/2178
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-21
 * Time: 오후 3:29
 */

public class Q2178
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] map = new int[N+2][M+2];
        boolean[][] check = new boolean[N+2][M+2];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                map[i][j] = str.charAt(j-1) - '0';
        }

        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> cQ = new LinkedList<>();

        rQ.add(1);
        cQ.add(1);

        // 큐가 빌 때까지
        while(!rQ.isEmpty())
        {
            int row = rQ.poll();
            int col = cQ.poll();

            int num = map[row][col];

            // 동서남북 방향에 길이 있는지 탐색
            for(int i=0; i<4; i++)
            {
                int newRow = row + dr[i];
                int newCol = col + dc[i];

                if(map[newRow][newCol] != 0 && !check[newRow][newCol])
                {
                    map[newRow][newCol] = map[row][col] + 1;

                    check[newRow][newCol] = true;
                    rQ.add(newRow);
                    cQ.add(newCol);
                }
            }
        }

        System.out.println(map[N][M]);
    }
}
