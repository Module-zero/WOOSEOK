/*
움직이는 미로 탈출

https://www.acmicpc.net/problem/16954
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-29
 * Time: 오후 4:03
 */

public class Q16954
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] ary = new char[8][8];
        for(int i=0; i<8; i++)
        {
            String str = br.readLine();

            for(int j=0; j<8; j++)
                ary[i][j] = str.charAt(j);
        }

        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        boolean[][][] check = new boolean[8][8][9];
        Queue<int[]> queue = new LinkedList<>();
        // [0] : row, [1] : col, [2] : time
        queue.add(new int[]{7, 0, 0});
        check[7][0][0] = true;

        // 내가 이동(벽이 나랑 겹치면 이동할 수 없게 된다.)
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            // 8초 이후면 모든 벽이 없어지므로 어느 장소에 있든 도착 지점으로 갈 수 있으므로 1 출력 후 종료
            if(tmp[2] == 8)
            {
                System.out.println("1");
                return;
            }

            // 벽이 r에 있었으면 t초 후에는 r+t 위치에 존재 => r-t에 장애물이 있었으면 t초 후인 현재 r에 존재 == 현재 위치
            int aryRow = tmp[0] - tmp[2];
            // 인덱스를 넘지 않으면 현재 맵에 존재
            if(aryRow >= 0 && aryRow < 8)
            {
                // 벽이랑 겹치면 이동할 수 없음
                if(ary[aryRow][tmp[1]] == '#')
                    continue;
            }

            for(int i=0; i<9; i++)
            {
                // 인덱스를 초과하면 종료
                int newRow = tmp[0] + dr[i];
                if(newRow < 0 || newRow >= 8)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 0 || newCol >= 8)
                    continue;

                // 도착 지점이면 1 출력 후 종료
                if(newRow == 0 && newCol == 7)
                {
                    System.out.println("1");
                    return;
                }

                // 전진할 곳에 벽이 있는지 검사하기 위한 좌표를 구한다.
                int newAryRow = newRow - tmp[2];

                // 범위를 벗어나면 주어진 맵 밖이므로 벽이 없음
                if(newAryRow < 0)
                {
                    if(!check[newRow][newCol][tmp[2] + 1])
                    {
                        check[newRow][newCol][tmp[2] + 1] = true;
                        queue.add(new int[]{newRow, newCol, tmp[2] + 1});
                    }
                }
                else
                {
                    // 벽이 아니고 한 번도 방문한 적 없으면 전진
                    if (ary[newAryRow][newCol] != '#' && !check[newRow][newCol][tmp[2] + 1])
                    {
                        check[newRow][newCol][tmp[2] + 1] = true;
                        queue.add(new int[]{newRow, newCol, tmp[2] + 1});
                    }
                }
            }
        }

        System.out.println("0");
    }
}
