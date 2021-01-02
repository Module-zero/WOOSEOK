/*
네모네모 시력검사

https://www.acmicpc.net/problem/18242
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-28
 * Time: 오후 2:00
 */

public class Q18242
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        char[][] ary = new char[101][101];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }

        int ur, uc, dr, dc;
        ur = uc = dr = dc = -1;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(ary[i][j] == '#' && ur == -1)
                {
                    ur = i;
                    uc = j;
                    dc = j;
                }

                if(ary[i][j] == '#' && ur != -1)
                    dr = i;
            }
        }

        int size = (dr - ur + 1);
        int cr = ur + size/2;
        int cc = uc + size/2;

        if(ary[ur][cc] == '.')
            System.out.println("UP");
        else if(ary[dr][cc] == '.')
            System.out.println("DOWN");
        else if(ary[cr][uc] == '.')
            System.out.println("LEFT");
        else if(ary[cr][cc + size/2] == '.')
            System.out.println("RIGHT");
    }
}
