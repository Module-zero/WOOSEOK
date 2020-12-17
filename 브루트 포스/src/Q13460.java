/*
구슬 탈출 2

https://www.acmicpc.net/problem/13460
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-19
 * Time: 오전 12:18
 */

public class Q13460
{
    static class Marble
    {
        int r;
        int c;

        public Marble() {}

        public void setMarble(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    static int N;
    static int M;
    static int[] dr = {0, 0, 1, -1};
    static int[] dc = {1, -1, 0, 0};
    static char[][] ary = new char[11][11];
    final static int LIMIT = 10;

    // 10번의 이동에 대한 방향을 비트마스크로 설정한다.
    public static int[] gen(int num)
    {
        int[] list = new int[LIMIT];
        // 방향 결정
        for(int i=0; i<LIMIT; i++)
        {
            list[i] = (num & 3);
            num >>= 2;
        }

        return list;
    }

    // 구슬을 굴린다.
    public static boolean[] simulate(char[][] ary, int dir, Marble marble)
    {
        if(ary[marble.r][marble.c] == '.')
            return new boolean[]{false, false};

        boolean moved = false;
        int newR = marble.r;
        int newC = marble.c;
        while(true)
        {
            newR += dr[dir];
            if(newR < 0 || newR >= N)
                return new boolean[]{moved, false};
            newC += dc[dir];
            if(newC < 0 || newC >= M)
                return new boolean[]{moved, false};

            // 장애물이면 return
            if(ary[newR][newC] == '#')
                return new boolean[]{moved, false};
            // 다른 구슬이 있으면 return
            else if(ary[newR][newC] == 'R' || ary[newR][newC] == 'B')
                return new boolean[]{moved, false};
            // 빈 칸이면 이동
            else if(ary[newR][newC] == '.')
            {
                char tmp = ary[newR][newC];
                ary[newR][newC] = ary[marble.r][marble.c];
                ary[marble.r][marble.c] = tmp;

                marble.setMarble(newR, newC);
                moved = true;
            }
            // 구멍에 들어감
            else if(ary[newR][newC] == 'O')
            {
                ary[marble.r][marble.c] = '.';
                moved = true;
                return new boolean[]{moved, true};
            }
        }
    }

    public static int foo(int[] dirs)
    {
        // 맵 복사
        char[][] tmp = new char[11][11];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
                tmp[i][j] = ary[i][j];
        }

        Marble red, blue;
        red = new Marble();
        blue = new Marble();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 빨간 구슬의 위치
                if(tmp[i][j] == 'R')
                    red.setMarble(i, j);
                // 파란 구슬의 위치
                else if(tmp[i][j] == 'B')
                    blue.setMarble(i, j);
            }
        }

        int cnt = 0;
        for(int dir : dirs)
        {
            cnt++;

            boolean hole1 = false;
            boolean hole2 = false;

            while(true)
            {
                boolean[] b1 = simulate(tmp, dir, red);
                boolean[] b2 = simulate(tmp, dir, blue);

                // 구슬이 더 이상 움직이지 않으면 탈출
                if(!b1[0] && !b2[0])
                    break;

                // 빨간 구슬이 구멍에 들어갔으면 true
                if(b1[1])
                    hole1 = true;
                // 파란 구슬이 구멍에 들어갔으면 true
                if(b2[1])
                    hole2 = true;
            }

            // 파란 구슬이 들어갔거나 둘 다 들어갔으면 -1 반환
            if(hole2) return -1;
            // 빨간 구슬만 들어갔으면 횟수 반환
            if(hole1) return cnt;
        }

        // 구멍에 들어가지 않았으므로 -1 반환
        return -1;
    }

    public static boolean valid(int[] dirs)
    {
        for(int i=0; i<LIMIT-1; i++)
        {
            // 서로 반대 방향이면 움직였을 때 원위치이므로 false
            if(dirs[i] == 0 && dirs[i+1] == 1)
                return false;
            if(dirs[i] == 1 && dirs[i+1] == 0)
                return false;
            if(dirs[i] == 2 && dirs[i+1] == 3)
                return false;
            if(dirs[i] == 3 && dirs[i+1] == 2)
                return false;
            // 같은 방향이면 의미가 없으므로 false
            if(dirs[i] == dirs[i+1])
                return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        int ans = -1;
        for(int k=0; k<(1 << (LIMIT*2)); k++)
        {
            int[] list = gen(k);
            if(!valid(list))
                continue;

            int cur = foo(list);
            // 구슬이 들어가지 않았거나 파란 구슬이 들어갔으면 다음 방향으로 시도
            if(cur == -1)
                continue;

            // 최솟값 기록
            if(ans == -1 || ans > cur)
                ans = cur;
        }

        System.out.println(ans);
    }
}
