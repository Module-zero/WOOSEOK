/*
달팽이

https://www.acmicpc.net/problem/1913
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 12:16
 */

public class Q1913
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int target = Integer.parseInt(br.readLine());

        int[][] ary = new int[1000][1000];
        int[] dr = {1, 0, -1, 0};
        int[] dc = {0, 1, 0, -1};

        int r = 0, c = 0;
        int num = N * N;

        int dir = 3;
        ary[0][0] = num--;
        int tr = 1;
        int tc = 1;
        while(num > 0)
        {
            dir = (dir + 1) % 4;

            while(num > 0)
            {
                int newR = r + dr[dir];
                if(newR < 0 || newR >= N)
                    break;
                int newC = c + dc[dir];
                if(newC < 0 || newC >= N)
                    break;

                if(ary[newR][newC] != 0)
                    break;

                if(num == target)
                {
                    tr = newR + 1;
                    tc = newC + 1;
                }

                ary[newR][newC] = num;
                r = newR;
                c = newC;
                num--;
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                sb.append(ary[i][j]).append(' ');
            sb.append('\n');
        }

        sb.append(tr).append(' ').append(tc);
        System.out.println(sb.toString());
    }
}
