/*
색종이

https://www.acmicpc.net/problem/2563
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 6:04
 */

public class Q2563
{
    static class Paper implements Comparable<Paper>
    {
        int x;
        int y;

        public Paper(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Paper o)
        {
            if(x == o.x)
                return y - o.y;
            else
                return x - o.x;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Paper[] papers = new Paper[101];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            papers[i] = new Paper(x, y);
        }

        boolean[][] ary = new boolean[101][101];
        for(int i=0; i<N; i++)
        {
            int x = papers[i].x;
            int y = papers[i].y;

            for(int r=y; r<y+10; r++)
            {
                for(int c=x; c<x+10; c++)
                    ary[r][c] = true;
            }
        }

        int sum = 0;
        for(int i=0; i<100; i++)
        {
            for(int j=0; j<100; j++)
            {
                if(ary[i][j])
                    sum++;
            }
        }

        System.out.println(sum);
    }
}
