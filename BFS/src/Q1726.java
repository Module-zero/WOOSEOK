/*
로봇

https://www.acmicpc.net/problem/1726
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
 * Date: 2021-01-04
 * Time: 오후 8:30
 */

public class Q1726
{
    public static int direction(int robot, int dir)
    {
        int cnt = 0;

        if(robot == 1)
        {
            if(dir == 2)
                cnt+=2;
            else if(dir == 3 || dir == 4)
                cnt++;
        }
        else if(robot == 2)
        {
            if(dir == 1)
                cnt+=2;
            else if(dir == 3 || dir == 4)
                cnt++;
        }
        else if(robot == 3)
        {
            if(dir == 4)
                cnt+=2;
            else if(dir == 1 || dir == 2)
                cnt++;
        }
        else if(robot == 4)
        {
            if(dir == 3)
                cnt+=2;
            else if(dir == 1 || dir == 2)
                cnt++;
        }

        return cnt;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[][] ary = new int[101][101];
        for(int i=1; i<=M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=1; j<=N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int startR = Integer.parseInt(st.nextToken());
        int startC = Integer.parseInt(st.nextToken());
        int startD = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int endR = Integer.parseInt(st.nextToken());
        int endC = Integer.parseInt(st.nextToken());
        int endD = Integer.parseInt(st.nextToken());
        
        Queue<int[]> queue = new LinkedList<>();
        int[] dr = {-999, 0, 0, 1, -1};
        int[] dc = {-999, 1, -1, 0, 0};

        int[][][] check = new int[101][101][5];

        queue.add(new int[]{startR, startC, startD});
        check[startR][startC][startD] = 0;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            if(tmp[0] == endR && tmp[1] == endC && tmp[2] == endD)
            {
                System.out.println(check[endR][endC][endD]);
                return;
            }

            int d = tmp[2];
            for(int k=1; k<=3; k++)
            {
                int newR = tmp[0] + dr[d] * k;
                if(newR < 1 || newR > M)
                    break;
                int newC = tmp[1] + dc[d] * k;
                if(newC < 1 || newC > N)
                    break;

                if(ary[newR][newC] == 1)
                    break;

                if(check[newR][newC][d] == 0)
                {
                    queue.add(new int[]{newR, newC, d});
                    check[newR][newC][d] = check[tmp[0]][tmp[1]][d] + 1;
                }
            }

            for(int k=1; k<5; k++)
            {
                if(k == d)
                    continue;

                int dist = direction(d, k);
                if(check[tmp[0]][tmp[1]][k] == 0)
                {
                    queue.add(new int[]{tmp[0], tmp[1], k});
                    check[tmp[0]][tmp[1]][k] = check[tmp[0]][tmp[1]][d] + dist;
                }
            }
        }
    }
}
