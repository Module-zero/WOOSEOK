/*
두 동전

https://www.acmicpc.net/problem/16197
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 7:00
 */

public class Q16197
{
    static int N;
    static int M;
    static int[][] map = new int[21][21];

    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int min = Integer.MAX_VALUE;

    public static void foo(int r1, int c1, int r2, int c2, int cnt)
    {
        if(cnt > 10)
            return;

        for(int i=0; i<4; i++)
        {
            boolean tokenOneOut = false;
            boolean tokenTwoOut = false;

            int newR1 = r1 + dr[i];
            if(newR1 <= 0 || newR1 > N)
                tokenOneOut = true;

            int newC1 = c1 + dc[i];
            if(newC1 <= 0 || newC1 > M)
                tokenOneOut = true;

            int newR2 = r2 + dr[i];
            if(newR2 <= 0 || newR2 > N)
                tokenTwoOut = true;

            int newC2 = c2 + dc[i];
            if(newC2 <= 0 || newC2 > M)
                tokenTwoOut = true;

            // 둘 다 떨어졌을 경우 다음 방향
            if(tokenOneOut && tokenTwoOut)
                continue;
            // 하나만 떨어졌을 경우
            else if(tokenOneOut || tokenTwoOut)
            {
                if(min > cnt+1)
                    min = cnt+1;

                return;
            }

            // 벽이면 자기 위치로
            if(map[newR1][newC1] == '#')
            {
                newR1 = r1;
                newC1 = c1;
            }

            if(map[newR2][newC2] == '#')
            {
                newR2 = r2;
                newC2 = c2;
            }

            foo(newR1, newC1, newR2, newC2, cnt+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] token = new int[2][2];
        int tCnt = 0;

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
            {
                map[i][j] = str.charAt(j - 1);
                if(map[i][j] == 'o')
                {
                    token[tCnt][0] = i;
                    token[tCnt][1] = j;
                    tCnt++;
                }
            }
        }

        foo(token[0][0], token[0][1], token[1][0], token[1][1], 0);

        if(min > 10)
            min = -1;

        System.out.println(min);
    }
}
