/*
아기 상어

https://www.acmicpc.net/problem/16236
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
    static int N;
    static int[][] ary = new int[20][20];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    // 첫 크기는 2
    static int size = 2;

    public static int[] bfs(int r, int c, int time)
    {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{r, c, time});
        // 유망한 정답들을 넣어둘 동적 배열
        ArrayList<int[]> ans = new ArrayList<>();

        // 각 칸에 도달한 시간을 저장할 배열(들렀는지 확인도 겸용)
        int[][] second = new int[20][20];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                second[i][j] = -1;
        }

        // 시작 지점에 시작 시간 저장
        second[r][c] = time;
        queue.add(new int[]{r, c, time});

        while(!queue.isEmpty())
        {
            int[] info = queue.peek();

            while (info[2] == time)
            {
                int[] tmp = queue.poll();

                for (int i = 0; i < 4; i++)
                {
                    int newRow = tmp[0] + dr[i];
                    if (newRow < 0 || newRow >= N)
                        continue;

                    int newCol = tmp[1] + dc[i];
                    if (newCol < 0 || newCol >= N)
                        continue;

                    // 이미 들른 곳이면 스킵
                    if (second[newRow][newCol] != -1)
                        continue;

                    // 자신보다 큰 물고기는 먹을 수 없음

                    // 길이면 전진
                    if (ary[newRow][newCol] == 0)
                    {
                        second[newRow][newCol] = second[tmp[0]][tmp[1]] + 1;
                        queue.add(new int[]{newRow, newCol, second[newRow][newCol]});
                    }
                    // 자신보다 작은 물고기는 먹는다.
                    else if (ary[newRow][newCol] < size)
                    {
                        second[newRow][newCol] = second[tmp[0]][tmp[1]] + 1;
                        ans.add(new int[]{newRow, newCol, second[newRow][newCol]});
                    }
                    // 같은 사이즈면 지나갈 수만 있다.
                    else if (ary[newRow][newCol] == size)
                    {
                        second[newRow][newCol] = second[tmp[0]][tmp[1]] + 1;
                        queue.add(new int[]{newRow, newCol, second[newRow][newCol]});
                    }
                }

                info = queue.peek();
                if(queue.isEmpty())
                    break;
            }

            // 정답 후보를 하나라도 찾았다면
            if(!ans.isEmpty())
            {
                int newR = N;
                int newC = N;

                for(int i=0; i<ans.size(); i++)
                {
                    int[] location = ans.get(i);

                    // 더 위에 있는 좌표면 변경
                    if(location[0] < newR)
                    {
                        newR = location[0];
                        newC = location[1];
                    }
                    // 더 왼쪽에 있는 좌표면 변경
                    else if(location[0] == newR && location[1] < newC)
                    {
                        newR = location[0];
                        newC = location[1];
                    }
                }

                return new int[]{newR, newC, second[newR][newC]};
            }

            time++;
        }

        // 정답 후보를 하나도 못찾았다면 -1 리턴
        return new int[]{-1, -1, -1};
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        int r = 0;
        int c = 0;

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                // 시작 지점 설정
                if(ary[i][j] == 9)
                {
                    r = i;
                    c = j;
                }
            }
        }

        // 소요 시간
        int time = 0;
        // 먹은 횟수
        int cnt = 0;

        while(true)
        {
            int[] ans = bfs(r, c, time);

            // 먹을 수 있는 물고기가 없으면 종료
            if(ans[0] == -1)
                break;

            // 위치 이동
            ary[r][c] = 0;
            r = ans[0];
            c = ans[1];
            ary[r][c] = 9;
            time = ans[2];

            cnt++;
            if(cnt == size)
            {
                size++;
                cnt = 0;
            }
        }

        System.out.println(time);
    }
}
