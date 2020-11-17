/*
거울 설치

https://www.acmicpc.net/problem/2151
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-16
 * Time: 오후 8:10
 */

public class Q2151
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[][] ary = new char[51][51];

        int startRow = -1;
        int startCol = -1;
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
            {
                ary[i][j] = str.charAt(j);
                if(ary[i][j] == '#' && startRow == -1)
                {
                    startRow = i;
                    startCol = j;
                }
            }
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        boolean[][][] check = new boolean[51][51][4];

        Queue<int[]> queue = new LinkedList<>();
        // [0], [1] : index, [2] : 거울을 놓은 횟수
        queue.add(new int[]{startRow, startCol, 0});
        for(int i=0; i<4; i++)
            check[startRow][startCol][i] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0];
                int newCol = tmp[1];

                // 벽에 막힐 때까지 전진
                while(true)
                {
                    newRow += dr[i];
                    if(newRow < 0 || newRow >= N)
                        break;

                    newCol += dc[i];
                    if(newCol < 0 || newCol >= N)
                        break;

                    if(ary[newRow][newCol] == '*' || check[newRow][newCol][i])
                        break;

                    if(ary[newRow][newCol] == '#' && (newRow != startRow || newCol != startCol))
                    {
                        System.out.println(tmp[2]);
                        return;
                    }
                    else if(ary[newRow][newCol] == '!')
                        queue.add(new int[]{newRow, newCol, tmp[2] + 1});

                    check[newRow][newCol][i] = true;
                }
            }
        }
    }
}
