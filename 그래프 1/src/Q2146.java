/*
다리 만들기

https://www.acmicpc.net/problem/2146
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
 * Date: 2020-10-26
 * Time: 오후 3:50
 */

public class Q2146
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[100][100];

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                map[i][j] = Integer.parseInt(st.nextToken());
        }

        // [0] : row, [1] : column
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[100][100];
        int[] dr = new int[]{-1, 0, 0, 1};
        int[] dc = new int[]{0, -1, 1, 0};
        int cnt = 1;

        // 각각의 섬에 번호를 매긴다.
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                // 이미 들른 육지인지 검사
                // 들르지 않았던 육지면 섬 번호를 매긴다.
                if(map[i][j] != 0 && !check[i][j])
                {
                    check[i][j] = true;
                    map[i][j] = cnt;
                    queue.add(new int[]{i, j});

                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        // 오른쪽과 아래쪽이 육지인지 검사해서 큐에 넣는다.
                        for(int k=0; k<4; k++)
                        {
                            int newRow = tmp[0] + dr[k];
                            if(newRow < 0 || newRow >= N)
                                continue;

                            int newCol = tmp[1] + dc[k];
                            if(newCol < 0 || newCol >= N)
                                continue;

                            if(map[newRow][newCol] != 0 && !check[newRow][newCol])
                            {
                                map[newRow][newCol] = cnt;
                                check[newRow][newCol] = true;
                                queue.add(new int[]{newRow, newCol});
                            }
                        }
                    }

                    cnt++;
                }
            }
        }

        int ans = Integer.MAX_VALUE;
        // 거리를 저장할 배열 생성(check도 겸함)
        int[][] dist = new int[100][100];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                dist[i][j] = -1;

                // 육지면 거리를 0으로 한 후(BFS의 시작점으로 저장) 큐에 넣는다.
                if(map[i][j] != 0)
                {
                    dist[i][j] = 0;
                    queue.add(new int[]{i, j});
                }
            }
        }

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int k=0; k<4; k++)
            {
                int newRow = tmp[0] + dr[k];
                if(newRow < 0 || newRow >= N)
                    continue;

                int newCol = tmp[1] + dc[k];
                if(newCol < 0 || newCol >= N)
                    continue;

                // 바다면 가장 가까운 육지로부터의 거리를 저장(BFS)
                if(dist[newRow][newCol] == -1)
                {
                    dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
                    map[newRow][newCol] = map[tmp[0]][tmp[1]];
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                for(int k=0; k<4; k++)
                {
                    int newRow = i + dr[k];
                    if(newRow < 0 || newRow >= N)
                        continue;

                    int newCol = j + dc[k];
                    if(newCol < 0 || newCol >= N)
                        continue;

                    // 다른 그룹이면 거리의 합이 다리의 개수
                    if(map[i][j] != map[newRow][newCol])
                    {
                        int sum = dist[i][j] + dist[newRow][newCol];
                        if(ans > sum)
                            ans = sum;
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
