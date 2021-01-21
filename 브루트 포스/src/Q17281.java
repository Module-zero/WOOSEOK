/*
⚾

https://www.acmicpc.net/problem/17281
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-30
 * Time: 오후 11:17
 */

public class Q17281
{
    public static int N;
    public static int[][] ary = new int[51][10];
    public static int[] order = new int[9];
    public static boolean[] check = new boolean[9];
    public static int max = Integer.MIN_VALUE;

    public static void recursive(int index)
    {
        if(index == 3)
        {
            recursive(index+1);
            return;
        }

        if(index == 9)
        {
            int id = 0;
            int ans = 0;
            for(int inning=0; inning<N; inning++)
            {
                int out = 0;
                boolean[] base = new boolean[3];

                while(out < 3)
                {
                    switch(ary[inning][order[id]])
                    {
                        case 0:
                            out++;
                            break;
                        case 1:
                            if(base[2])
                                ans++;

                            base[2] = base[1];
                            base[1] = base[0];
                            base[1] = true;
                            break;
                        case 2:
                            if(base[2])
                                ans++;
                            if(base[1])
                                ans++;

                            base[2] = base[0];
                            base[1] = true;
                            base[0] = false;
                            break;
                        case 3:
                            if(base[2])
                                ans++;
                            if(base[1])
                                ans++;
                            if(base[0])
                                ans++;

                            base[2] = true;
                            base[1] = false;
                            base[0] = false;
                            break;
                        case 4:
                            if(base[2])
                                ans++;
                            if(base[1])
                                ans++;
                            if(base[0])
                                ans++;

                            ans++;
                            base[2] = false;
                            base[1] = false;
                            base[0] = false;
                            break;
                    }

                    id = (id + 1) % 9;
                }
            }

            max = Integer.max(max, ans);
            return;
        }

        for(int i=0; i<9; i++)
        {
            if(check[i])
                continue;

            check[i] = true;
            order[index] = i;
            recursive(index+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<9; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        recursive(0);

        System.out.println(max);
    }
}
