/*
빙고

https://www.acmicpc.net/problem/2578
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-29
 * Time: 오후 9:20
 */

public class Q2578
{
    static class Location
    {
        int r;
        int c;

        public Location(int r, int c)
        {
            this.r = r;
            this.c = c;
        }
    }

    public static boolean check(boolean[][] check)
    {
        int cnt = 0;
        boolean ldia = true;
        boolean rdia = true;
        for(int i=0; i<5; i++)
        {
            int j = 0;
            for(; j<5; j++)
            {
                if(!check[i][j])
                    break;
            }

            if(j == 5)
                cnt++;

            j = 0;
            for(; j<5; j++)
            {
                if(!check[j][i])
                    break;
            }

            if(j == 5)
                cnt++;

            if(!check[i][i])
                ldia = false;

            if(!check[i][4-i])
                rdia = false;
        }

        if(ldia)
            cnt++;
        if(rdia)
            cnt++;

        return cnt >= 3;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[][] ary = new int[6][6];
        Location[] locations = new Location[26];
        for(int i=0; i<5; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                locations[ary[i][j]] = new Location(i, j);
            }
        }

        int[][] ans = new int[6][6];
        for(int i=0; i<5; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<5; j++)
                ans[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] check = new boolean[5][5];
        int cnt = 1;
        for(int i=0; i<5; i++)
        {
            for(int j=0; j<5; j++)
            {
                int num = ans[i][j];
                Location l = locations[num];
                check[l.r][l.c] = true;
                if(check(check))
                {
                    System.out.println(cnt);
                    return;
                }
                cnt++;
            }
        }
    }
}
