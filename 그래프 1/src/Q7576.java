/*
토마토

https://www.acmicpc.net/problem/7576
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
 * Date: 2020-10-21
 * Time: 오후 4:24
 */

public class Q7576
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] ary = new int[N+2][M+2];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int i=1; i<=N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                // 토마토를 탐색한다.
                if(ary[i][j] == 1)
                    queue.add(new int[]{i, j});
            }
        }

        while(!queue.isEmpty())
        {
            int[] tomato = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tomato[0] + dr[i];
                int newCol = tomato[1] + dc[i];
                // 범위에서 벗어나면 다음 방향 탐색
                if(newRow < 1 || newRow > N)
                    continue;
                if(newCol < 1 || newCol > M)
                    continue;

                // 어린 토마토면 옮는다.
                if(ary[newRow][newCol] == 0)
                {
                    ary[newRow][newCol] = ary[tomato[0]][tomato[1]] + 1;
                    queue.add(new int[]{newRow, newCol});
                }
            }
        }

        int ans = 0;
        boolean isYoung = false;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                // 토마토가 모두 익지는 못하는 상황(안익은 토마토가 하나라도 있을 경우)
                if(ary[i][j] == 0)
                {
                    ans = 0;
                    isYoung = true;
                    break;
                }

                if(ary[i][j] > ans)
                    ans = ary[i][j];
            }

            if(isYoung)
                break;
        }

        System.out.println(ans-1);
    }
}
