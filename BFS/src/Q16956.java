/*
늑대와 양

https://www.acmicpc.net/problem/16956
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-16
 * Time: 오후 3:16
 */

public class Q16956
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        char[][] ary = new char[501][501];

        for(int i=0; i<R; i++)
        {
            String str = br.readLine();

            for(int j=0; j<C; j++)
                ary[i][j] = str.charAt(j);
        }

        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
            {
                if(ary[i][j] == '.')
                    ary[i][j] = 'D';
                else if(ary[i][j] == 'S')
                {
                    if(ary[i+1][j] == 'W')
                    {
                        System.out.println(0);
                        return;
                    }
                    else if(ary[i][j+1] == 'W')
                    {
                        System.out.println(0);
                        return;
                    }
                }
                else if(ary[i][j] == 'W')
                {
                    if(ary[i+1][j] == 'S')
                    {
                        System.out.println(0);
                        return;
                    }
                    else if(ary[i][j+1] == 'S')
                    {
                        System.out.println(0);
                        return;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(1).append('\n');
        for(int i=0; i<R; i++)
        {
            for(int j=0; j<C; j++)
                sb.append(ary[i][j]);

            sb.append('\n');
        }

        System.out.print(sb.toString());
    }
}
