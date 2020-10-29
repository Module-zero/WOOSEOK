/*
탈출

https://www.acmicpc.net/problem/3055
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
 * Time: 오후 9:46
 */

public class Q3055
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        char[][] ary = new char[51][51];
        int[] startIndex = {};
        int[] destIndex = {};

        for(int i=1; i<=R; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=C; j++)
            {
                ary[i][j] = str.charAt(j - 1);

                if(ary[i][j] == 'S')
                    startIndex = new int[]{i, j};
                else if(ary[i][j] == 'D')
                    destIndex = new int[]{i, j};
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        int[][] waterAry = new int[51][51];
        boolean[][] waterCheck = new boolean[51][51];
        for(int i=1; i<=R; i++)
        {
            for(int j=1; j<=C; j++)
            {
                // 물이면 몇 초에 어디로 도달하는지 구한다.
                if(ary[i][j] == '*')
                {
                    // [0], [1] : location, [2] : second
                    queue.add(new int[]{i, j, 0});
                    waterCheck[i][j] = true;
                }
            }
        }

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0] + dr[i];
                if(newRow < 1 || newRow > R)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 1 || newCol > C)
                    continue;

                // 물은 비버의 소굴과 돌로 이동할 수 없다.
                if(ary[newRow][newCol] == 'X' || ary[newRow][newCol] == 'D')
                    continue;

                // 갈 수 있는 칸이며, 들르지 않았던 곳이면 체크
                if(!waterCheck[newRow][newCol])
                {
                    waterCheck[newRow][newCol] = true;
                    waterAry[newRow][newCol] = tmp[2] + 1;
                    queue.add(new int[]{newRow, newCol, tmp[2] + 1});
                }
            }
        }

        // 정답 구하기 시작
        boolean[][] check = new boolean[51][51];
        queue.add(new int[]{startIndex[0], startIndex[1], 0});

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            // 현재 시간의 +1초
            int nextTime = tmp[2] + 1;
            for(int i=0; i<4; i++)
            {
                // 유효 범위 검사
                int newRow = tmp[0] + dr[i];
                if(newRow < 1 || newRow > R)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 1 || newCol > C)
                    continue;

                // 비버의 굴에 도착하면 출력 후 종료
                if(ary[newRow][newCol] == 'D')
                {
                    System.out.println(nextTime);
                    return;
                }

                // 이미 들렀거나, 물이 찰 예정이거나, 돌이면 갈 수 없음
                if(check[newRow][newCol] || ary[newRow][newCol] == 'X' || (waterAry[newRow][newCol] != 0 && nextTime >= waterAry[newRow][newCol]))
                    continue;

                check[newRow][newCol] = true;
                queue.add(new int[]{newRow, newCol, nextTime});
            }
        }

        System.out.println("KAKTUS");
    }
}
