/*
뱀

https://www.acmicpc.net/problem/3190
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
 * Date: 2020-12-20
 * Time: 오후 9:49
 */

public class Q3190
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());

        int[][] map = new int[101][101];
        map[0][0] = 1;
        for(int i=0; i<K; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 사과
            map[r-1][c-1] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        int[] sec = new int[101];
        char[] dirs = new char[101];
        for(int i=0; i<L; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            sec[i] = Integer.parseInt(st.nextToken());
            dirs[i] = st.nextToken().charAt(0);
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        int headR = 0;
        int headC = 0;
        // 우, 하, 좌, 상
        int[] dr = {0, 1, 0, -1};
        int[] dc = {1, 0, -1, 0};
        int dir = 0;
        int time = 1;
        int secId = 0;
        while(true)
        {
            // 머리 전진
            headR += dr[dir];
            if(headR < 0 || headR >= N)
                break;

            headC += dc[dir];
            if(headC < 0 || headC >= N)
                break;

            // 자기 몸에 닿으면 종료
            if(map[headR][headC] == 1)
                break;

            queue.add(new int[]{headR, headC});
            // 사과가 아니면 길이가 길어지지 않으므로 꼬리 이동(제거)
            if(map[headR][headC] != 2)
            {
                int[] tmp = queue.poll();
                map[tmp[0]][tmp[1]] = 0;
            }

            // 뱀 표시
            map[headR][headC] = 1;

            // 방향 전환을 해야하는지 검사
            if(secId < L && time == sec[secId])
            {
                // 왼쪽
                if(dirs[secId] == 'L')
                {
                    dir = dir - 1;
                    if(dir < 0)
                        dir = 3;
                }
                // 오른쪽
                else
                    dir = (dir + 1) % 4;

                secId++;
            }

            // 1초 경과
            time++;
        }

        System.out.println(time);
    }
}
