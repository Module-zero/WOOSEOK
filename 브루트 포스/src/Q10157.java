/*
자리배정

https://www.acmicpc.net/problem/10157
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-31
 * Time: 오후 7:22
 */

public class Q10157
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());
        int[][] ary = new int[1001][1001];
        int r = 0;
        int c = 1;

        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int num = 1;
        int dir = 0;
        int lim = R * C;

        int tr = -1;
        int tc = -1;
        while(num <= lim)
        {
            while(true)
            {
                int newR = r + dr[dir];
                if(newR < 1 || newR > R)
                    break;

                int newC = c + dc[dir];
                if(newC < 1 || newC > C)
                    break;

                if(ary[newR][newC] != 0)
                    break;

                r = newR;
                c = newC;

                if(num == K)
                {
                    tr = r;
                    tc = c;
                    break;
                }

                ary[r][c] = num++;
            }

            if(tr != -1)
                break;

            dir = (dir + 1) % 4;
        }

        if(tr == -1)
            System.out.println(0);
        else
            System.out.println(tc + " " + tr);
    }
}
