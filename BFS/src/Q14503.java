/*
로봇 청소기

https://www.acmicpc.net/problem/14503
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
 * Date: 2021-01-05
 * Time: 오후 11:50
 */

public class Q14503
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        int[][] ary = new int[51][51];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 0, 1, 0};
        int[] dc = {0, 1, 0, -1};

        Queue<int[]> queue = new LinkedList<>();
        // [0], [1] : 행열, [2] : 방향, [3] : 회전을 몇 번 했는지
        queue.add(new int[]{r, c, d, 0});
        boolean[][] check = new boolean[51][51];
        check[r][c] = true;

        int cnt = 1;
        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            int dir = (tmp[2]-1 < 0) ? 3 : tmp[2]-1;
            int newR = tmp[0] + dr[dir];
            int newC = tmp[1] + dc[dir];

            // a : 왼쪽 방향에 아직 청소하지 않은 공간이 존재한다면, 그 방향으로 회전한 다음 한 칸을 전진하고 1번부터 진행한다.
            if(ary[newR][newC] == 0 && !check[newR][newC])
            {
                queue.add(new int[]{newR, newC, dir, 0});
                check[newR][newC] = true;
                cnt++;
            }
            // c : 네 방향 모두 청소가 이미 되어있거나 벽인 경우에는, 바라보는 방향을 유지한 채로 한 칸 후진을 하고 2번으로 돌아간다.
            else if(tmp[3] == 4)
            {
                // d : 네 방향 모두 청소가 이미 되어있거나 벽이면서, 뒤쪽 방향이 벽이라 후진도 할 수 없는 경우에는 작동을 멈춘다.
                if(ary[tmp[0] - dr[tmp[2]]][tmp[1] - dc[tmp[2]]] == 1)
                {
                    System.out.println(cnt);
                    return;
                }

                queue.add(new int[]{tmp[0] - dr[tmp[2]], tmp[1] - dc[tmp[2]], tmp[2], 0});
            }
            // b : 왼쪽 방향에 청소할 공간이 없다면, 그 방향으로 회전하고 2번으로 돌아간다.
            else if(ary[newR][newC] == 1 || check[newR][newC])
                queue.add(new int[]{tmp[0], tmp[1], dir, tmp[3]+1});
        }

        System.out.println(cnt);
    }
}
