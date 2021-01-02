/*
뱀

https://www.acmicpc.net/problem/3190
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-30
 * Time: 오전 4:04
 */

public class Q3190_2
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] ary = new int[101][101];
        for(int i=0; i<K; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 사과는 2
            ary[r-1][c-1] = 2;
        }

        char[] dirs = new char[10001];
        int L = Integer.parseInt(br.readLine());
        for(int i=0; i<L; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int X = Integer.parseInt(st.nextToken());
            char C = st.nextToken().charAt(0);
            dirs[X] = C;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        // 1은 뱀
        ary[0][0] = 1;

        // 우, 하, 좌, 상 순
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};

        int t = 1;
        int dir = 0;
        int r = 0;
        int c = 0;
        while(true)
        {
            r += dr[dir];
            if(r < 0 || r >= N)
                break;

            c += dc[dir];
            if(c < 0 || c >= N)
                break;

            // 자기 몸일 경우
            if(ary[r][c] == 1)
                break;

            // 머리 이동
            queue.add(new int[]{r, c});
            // 사과가 없을 경우 꼬리 제거
            if(ary[r][c] == 0)
            {
                int[] tmp = queue.poll();
                ary[tmp[0]][tmp[1]] = 0;
            }

            // 뱀
            ary[r][c] = 1;

            // 방향 전환
            switch(dirs[t])
            {
                case 'L':
                    dir -= 1;
                    if(dir < 0)
                        dir = 3;
                    break;
                case 'D':
                    dir = (dir + 1) % 4;
                    break;
                default:
                    break;
            }

            t++;
        }

        System.out.println(t);
    }
}
