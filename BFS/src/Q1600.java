/*
말이 되고픈 원숭이

https://www.acmicpc.net/problem/1600
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
 * Date: 2020-11-16
 * Time: 오후 5:56
 */

public class Q1600
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        int[][] ary = new int[201][201];
        for(int i=1; i<=H; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=W; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        // 칸이 1개면 종료
        if(W == 1 && H == 1)
        {
            System.out.println(0);
            return;
        }

        boolean[][][] check = new boolean[201][201][31];

        Queue<int[]> queue = new LinkedList<>();

        // [0], [1] : index, [2] : 움직인 횟수, [3] : 말처럼 움직인 횟수
        queue.add(new int[]{1, 1, 0, 0});
        check[1][1][0] = true;

        int[] dr = {-1, 0, 0, 1, -1, -2, -2, -1, 1, 2, 2, 1};
        int[] dc = {0, -1, 1, 0, -2, -1, 1, 2, 2, 1, -1, -2};

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0] + dr[i];
                if(newRow <= 0 || newRow > H)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol <= 0 || newCol > W)
                    continue;

                if(newRow == H && newCol == W)
                {
                    System.out.println(tmp[2] + 1);
                    return;
                }

                // 장애물이거나 들른 적 있으면 스킵
                if(ary[newRow][newCol] == 1 || check[newRow][newCol][tmp[3]])
                    continue;

                queue.add(new int[]{newRow, newCol, tmp[2]+1, tmp[3]});
                check[newRow][newCol][tmp[3]] = true;
            }

            // 말처럼 움직인 횟수가 K 미만이면 이동
            if(tmp[3] < K)
            {
                for (int i=4; i<12; i++)
                {
                    int newRow = tmp[0] + dr[i];
                    if(newRow <= 0 || newRow > H)
                        continue;

                    int newCol = tmp[1] + dc[i];
                    if(newCol <= 0 || newCol > W)
                        continue;

                    if(newRow == H && newCol == W)
                    {
                        System.out.println(tmp[2] + 1);
                        return;
                    }

                    if(ary[newRow][newCol] == 1 || check[newRow][newCol][tmp[3] + 1])
                        continue;

                    queue.add(new int[]{newRow, newCol, tmp[2] + 1, tmp[3] + 1});
                    check[newRow][newCol][tmp[3] + 1] = true;
                }
            }
        }

        System.out.println(-1);
    }
}
