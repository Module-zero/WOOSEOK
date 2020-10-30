/*
아기 상어

https://www.acmicpc.net/problem/16236
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
 * Date: 2020-10-30
 * Time: 오전 10:59
 */

public class Q16236
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[][] ary = new int[20][20];
        int r = 0, c = 0;
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());

                if(ary[i][j] == 9)
                {
                    r = i;
                    c = j;
                }
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> ans = new LinkedList<>();

        // [0], [1] : index, [2] : 크기, [3] : 시간
        queue.add(new int[]{r, c, 2, 0});
        // 잡아먹은 수
        int cnt = 0;

        while(true)
        {
            boolean[][] check = new boolean[20][20];
            check[r][c] = true;
            int[] info = queue.peek();
            int size = info[2];
            int time = info[3];

            // 먹을 수 있는 물고기 탐색
            while (!queue.isEmpty())
            {
                int second = queue.peek()[3];

                while (second == time)
                {
                    // 들른 곳인지 체크하기 위한 배열
                    int[] tmp = queue.poll();

                    for (int i = 0; i < 4; i++)
                    {
                        int newRow = tmp[0] + dr[i];
                        if (newRow < 0 || newRow >= N)
                            continue;

                        int newCol = tmp[1] + dc[i];
                        if (newCol < 0 || newCol >= N)
                            continue;

                        // 이미 들렀던 칸이면 들를 필요가 없음
                        if (check[newRow][newCol])
                            continue;

                        // 크기가 큰 물고기면 지나갈 수 없음
                        if (ary[newRow][newCol] > tmp[2])
                            continue;
                            // 길이면 지나갈 수 있음
                        else if (ary[newRow][newCol] == 0)
                        {
                            check[newRow][newCol] = true;
                            queue.add(new int[]{newRow, newCol, tmp[2], tmp[3] + 1});
                        }
                        // 크기가 같으면 지나갈 수만 있음
                        else if (ary[newRow][newCol] == tmp[2])
                        {
                            check[newRow][newCol] = true;
                            queue.add(new int[]{newRow, newCol, tmp[2], tmp[3] + 1});
                        }
                        // 크기가 나보다 작으면 먹을 수 있음
                        else
                        {
                            check[newRow][newCol] = true;
                            ans.add(new int[]{newRow, newCol, tmp[2], tmp[3] + 1});
                        }
                    }

                    if (!queue.isEmpty())
                        second = queue.peek()[3];
                    else
                        break;
                }

                // 먹을 수 있는 물고기가 있으면
                if (!ans.isEmpty())
                {
                    int ansR = N, ansC = N;
                    int s = 0;

                    while (!ans.isEmpty())
                    {
                        int[] location = ans.poll();
                        // 더 위에 있으면 우선적으로 먹는다.
                        if (location[0] < ansR)
                        {
                            ansR = location[0];
                            ansC = location[1];
                            s = location[3];
                        }
                        // 더 왼쪽에 있으면 우선적으로 먹는다.
                        else if (location[0] == ansR && location[1] < ansC)
                        {
                            ansR = location[0];
                            ansC = location[1];
                            s = location[3];
                        }
                    }

                    // 위치 이동
                    ary[r][c] = 0;
                    ary[ansR][ansC] = 9;
                    r = ansR;
                    c = ansC;
                    cnt++;

                    if(cnt == size)
                    {
                        size++;
                        cnt = 0;
                    }

                    queue.add(new int[]{r, c, size, s});

                    break;
                }
                else
                {
                    System.out.println(info[2]);
                    time++;
                }
            }

            System.out.println(size + " : " + cnt);

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                    System.out.print(ary[i][j] + " ");
                System.out.println();
            }
        }
    }
}
