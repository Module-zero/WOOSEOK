/*
치즈

https://www.acmicpc.net/problem/2636
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
 * Date: 2020-12-21
 * Time: 오후 6:15
 */

public class Q2636
{
    static int R;
    static int C;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int[][] ary = new int[101][101];
    static int[][] group;

    public static void grouping()
    {
        Queue<int[]> queue = new LinkedList<>();

        int gNum = 0;
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(group[i][j] != 0)
                    continue;

                queue.add(new int[]{i, j});
                group[i][j] = ++gNum;

                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();

                    for(int k=0; k<4; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR < 0 || newR >= R)
                            continue;

                        int newC = tmp[1] + dc[k];
                        if(newC < 0 || newC >= C)
                            continue;

                        if(ary[newR][newC] != ary[tmp[0]][tmp[1]])
                            continue;

                        if(group[newR][newC] == 0)
                        {
                            group[newR][newC] = gNum;
                            queue.add(new int[]{newR, newC});
                        }
                    }
                }
            }
        }
    }

    public static void melt()
    {
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(ary[i][j] == 1)
                {
                    for(int k=0; k<4; k++)
                    {
                        int newR = i + dr[k];
                        if(newR < 0 || newR >= R)
                            continue;

                        int newC = j + dc[k];
                        if(newC < 0 || newC >= C)
                            continue;

                        if(group[newR][newC] == 1)
                        {
                            ary[i][j] = 0;
                            break;
                        }
                    }
                }
            }
        }
    }

    public static int count()
    {
        int cnt = 0;
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
                if(ary[i][j] == 1)
                    cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        for(int i=0; i<R; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<C; j++)
                ary[i][j] = st.nextToken().charAt(0) - '0';
        }

        int ans = count();
        int sec = 0;
        while(true)
        {
            group = new int[101][101];
            // 공기와 치즈를 구분한다.
            grouping();
            // 1초가 지나고 치즈가 녹는다.
            sec++;
            melt();
            // 치즈 칸의 개수를 구한다.
            int cnt =  count();
            // 다 녹아 없어지면 종료
            if(cnt == 0)
                break;

            ans = cnt;
        }

        StringBuffer sb = new StringBuffer();
        sb.append(sec).append('\n').append(ans);
        System.out.println(sb.toString());
    }
}
