/*
벽 부수고 이동하기

https://www.acmicpc.net/problem/2206
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
 * Date: 2020-10-28
 * Time: 오후 10:49
 */

public class Q2206
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[N+1][M+1];
        int[][] dist = new int[N+1][M+1];
        boolean[][][] check = new boolean[N+1][M+1][2];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j-1) - '0';
        }

        Queue<int[]> queue = new LinkedList<>();

        // [0], [1] : 좌표, [2] : 벽을 부수지 않았으면 0, 부쉈으면 1
        queue.add(new int[]{1, 1, 0});
        check[1][1][0] = true;
        check[1][1][1] = true;
        dist[N][M] = -1;
        dist[1][1] = 1;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0] + dr[i];
                if(newRow < 1 || newRow > N)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 1 || newCol > M)
                    continue;

                // 정답이면 출력 후 종료
                if(newRow == N && newCol == M)
                {
                    System.out.println(dist[tmp[0]][tmp[1]] + 1);
                    return;
                }

                // 이미 들른 곳이면 큐에 넣지 않는다.
                if(check[newRow][newCol][tmp[2]])
                    continue;

                // 전진하려는 방향이 벽이고, 아직 벽을 부수지 않았으면 전진
                if(ary[newRow][newCol] == 1 && tmp[2] == 0)
                {
                    check[newRow][newCol][1] = true;
                    dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[]{newRow, newCol, 1});
                }
                // 갈 수 있는 길이면 전진
                else if(ary[newRow][newCol] == 0)
                {
                    check[newRow][newCol][tmp[2]] = true;
                    dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
                    queue.add(new int[]{newRow, newCol, tmp[2]});
                }
            }
        }

        System.out.println(dist[N][M]);
    }
}
