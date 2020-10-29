/*
벽 부수고 이동하기 2

https://www.acmicpc.net/problem/14442
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
 * Date: 2020-10-29
 * Time: 오후 2:52
 */

public class Q14442
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        // 맵 구성
        int[][] ary = new int[1001][1001];
        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j-1) - '0';
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        // K : 더 부술 수 있고/없고
        boolean[][][] check = new boolean[1001][1001][11];
        int[][] dist = new int[1001][1001];
        // 도달하지 못하면 -1.
        dist[N][M] = -1;
        // N과 M이 1일 경우를 대비해 나중에 선언
        dist[1][1] = 1;

        Queue<int[]> queue = new LinkedList<>();
        // [0] : row, [1] : col, [2] : cnt
        queue.add(new int[]{1, 1, 0});
        check[1][1][0] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                // 인덱스 검사
                int newRow = tmp[0] + dr[i];
                if(newRow < 1 || newRow > N)
                    continue;
                int newCol = tmp[1] + dc[i];
                if(newCol < 1 || newCol > M)
                    continue;

                if(newRow == N && newCol == M)
                {
                    System.out.println(dist[tmp[0]][tmp[1]] + 1);
                    return;
                }

                // 벽을 부술 수 없는데 해당 방향이 벽이면 갈 수 없음
                if(tmp[2] == K && ary[newRow][newCol] == 1)
                    continue;

                // 길이고 아직 방문하지 않았으면 전진
                if(ary[newRow][newCol] == 0 && !check[newRow][newCol][tmp[2]])
                {
                    check[newRow][newCol][tmp[2]] = true;
                    dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[]{newRow, newCol, tmp[2]});
                }
                // 벽이고 아직 방문하지 않았으면 부수고 전진
                else if(ary[newRow][newCol] == 1 && !check[newRow][newCol][tmp[2]+1])
                {
                    check[newRow][newCol][tmp[2] + 1] = true;
                    dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[]{newRow, newCol, tmp[2] + 1});
                }
            }
        }

        System.out.println(dist[N][M]);
    }
}
