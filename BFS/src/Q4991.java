/*
로봇 청소기

https://www.acmicpc.net/problem/4991
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-24
 * Time: 오후 11:22
 */

public class Q4991
{
    static int w;
    static int h;
    static char[][] ary = new char[21][21];
    static int[][][] dist = new int[21][21][21];
    static ArrayList<int[]> dust;
    static int dustNum;
    static boolean[] dustCheck;
    static int min;

    public static void foo(int index, int prev, int sum)
    {
        if(index == dustNum)
        {
            if(sum < min)
                min = sum;

            return;
        }

        for(int i=0; i<dustNum; i++)
        {
            if(dustCheck[i])
                continue;

            dustCheck[i] = true;

            int[] cur = dust.get(i);
            foo(index+1, i, sum + dist[prev+1][cur[0]][cur[1]]);

            dustCheck[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();
        while(true)
        {
            // 최솟값 초기화
            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if(w == 0 && h == 0)
                break;

            dust = new ArrayList<>();
            dustCheck = new boolean[10];

            int sRow = 0;
            int sCol = 0;

            for (int i = 0; i < h; i++)
            {
                String str = br.readLine();

                for (int j = 0; j < w; j++)
                {
                    ary[i][j] = str.charAt(j);
                    // 시작 지점
                    if (ary[i][j] == 'o')
                    {
                        sRow = i;
                        sCol = j;
                    }
                    // 먼지
                    else if(ary[i][j] == '*')
                        dust.add(new int[]{i, j});
                }
            }

            dustNum = dust.size();

            // k = 0 : 시작 지점에서의 거리, k = 1 ~ dustNum : 먼지에서 먼지까지 거리
            for(int k=0; k<=dustNum; k++)
            {
                for(int i=0; i<h; i++)
                {
                    for(int j=0; j<w; j++)
                        dist[k][i][j] = -1;
                }
            }

            int[] dr = {-1, 0, 0, 1};
            int[] dc = {0, -1, 1, 0};

            Queue<int[]> queue = new LinkedList<>();

            for(int k=0; k<=dustNum; k++)
            {
                // 먼지 위치에서 시작
                if(k != 0)
                {
                    sRow = dust.get(k-1)[0];
                    sCol = dust.get(k-1)[1];
                }

                // 시작 지점 초기화
                dist[k][sRow][sCol] = 0;

                queue.add(new int[]{sRow, sCol});

                while (!queue.isEmpty())
                {
                    int[] tmp = queue.poll();

                    for (int i = 0; i < 4; i++)
                    {
                        int newRow = tmp[0] + dr[i];
                        if (newRow < 0 || newRow >= h)
                            continue;

                        int newCol = tmp[1] + dc[i];
                        if (newCol < 0 || newCol >= w)
                            continue;

                        // 이미 들렀으면 다음 방향 검사 || 벽이면 다음 방향 검사
                        if (dist[k][newRow][newCol] != -1 || ary[newRow][newCol] == 'x')
                            continue;

                        queue.add(new int[]{newRow, newCol});
                        dist[k][newRow][newCol] = dist[k][tmp[0]][tmp[1]] + 1;
                    }
                }
            }

            // 방문할 수 없는 더러운 칸이 있는지 확인
            for(int i=0; i<dustNum; i++)
            {
                int[] cur = dust.get(i);
                if(dist[0][cur[0]][cur[1]] == -1)
                    min = -1;
            }

            if(min != -1)
            {
                for (int i = 0; i < dustNum; i++)
                {
                    dustCheck[i] = true;

                    int[] tmp = dust.get(i);
                    foo(1, i, dist[0][tmp[0]][tmp[1]]);

                    dustCheck[i] = false;
                }
            }

            sb.append(min).append('\n');
        }

        System.out.print(sb.toString());
    }
}
