/*
연구소

https://www.acmicpc.net/problem/14502
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-28
 * Time: 오후 3:25
 */

public class Q14502
{
    static int N;
    static int M;
    static int max = Integer.MIN_VALUE;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};

    public static void virus(int[][] map)
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 바이러스일 경우 퍼트린다.
                if(map[i][j] == 2)
                    spread(map, i, j);
            }
        }

        int cnt = 0;

        for(int i=0; i<N; i++)
        {
            for (int j=0; j<M; j++)
            {
                if (map[i][j] == 0)
                    cnt++;
                // 퍼졌던 바이러스를 다시 길로 바꾼다.
                else if(map[i][j] == 3)
                    map[i][j] = 0;
            }
        }

        if(max < cnt)
            max = cnt;
    }

    public static void spread(int[][] map, int row, int col)
    {
        for(int i=0; i<4; i++)
        {
            int newRow = row + dr[i];
            if(newRow < 0 || newRow >= N)
                continue;

            int newCol = col + dc[i];
            if(newCol < 0 || newCol >= M)
                continue;

            // 벽을 만날 경우 진행할 수 없다.
            if(map[newRow][newCol] == 1)
                continue;
            else if(map[newRow][newCol] == 0)
            {
                // 퍼진 바이러스는 3으로 표시한다.
                map[newRow][newCol] = 3;
                spread(map, newRow, newCol);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[8][8];

        // 연구소 입력
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        for(int first=0; first<N*M-2; first++)
        {
            if(ary[first/M][first%M] != 0)
                continue;

            // 1번째 벽을 세운다.
            ary[first/M][first%M] = 1;
            for(int second=first+1; second<N*M-1; second++)
            {
                if(ary[second/M][second%M] != 0)
                    continue;

                // 2번째 벽을 세운다.
                ary[second/M][second%M] = 1;
                for(int third=second+1; third<N*M; third++)
                {
                    if(ary[third/M][third%M] != 0)
                        continue;

                    // 3번째 벽을 세운다.
                    ary[third/M][third%M] = 1;

                    // 바이러스를 퍼트린다.
                    virus(ary);

                    // 벽을 다시 0으로
                    ary[third/M][third%M] = 0;
                }

                // 벽을 다시 0으로
                ary[second/M][second%M] = 0;
            }

            // 벽을 다시 0으로
            ary[first/M][first%M] = 0;
        }

        System.out.println(max);
    }
}
