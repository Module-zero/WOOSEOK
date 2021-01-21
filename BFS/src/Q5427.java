/*
불

https://www.acmicpc.net/problem/5427
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
 * Date: 2021-01-03
 * Time: 오후 6:04
 */

public class Q5427
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        StringBuffer sb = new StringBuffer();
        int tc = Integer.parseInt(br.readLine());
        while(tc-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            char[][] ary = new char[1001][1001];

            Queue<int[]> fire = new LinkedList<>();
            Queue<int[]> person = new LinkedList<>();
            for(int i=0; i<h; i++)
            {
                String str = br.readLine();
                for(int j=0; j<w; j++)
                {
                    ary[i][j] = str.charAt(j);
                    if(ary[i][j] == '*')
                        fire.add(new int[]{i, j, 1});
                    else if(ary[i][j] == '@')
                        person.add(new int[]{i, j, 1});
                }
            }

            int t = 1;

            while(true)
            {
                // 불길
                while(!fire.isEmpty())
                {
                    int[] tmp = fire.peek();
                    if(tmp[2] != t)
                        break;

                    fire.poll();
                    for(int k=0; k<4; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR < 0 || newR >= h)
                            continue;

                        int newC = tmp[1] + dc[k];
                        if(newC < 0 || newC >= w)
                            continue;

                        if(ary[newR][newC] == '#' || ary[newR][newC] == '*')
                            continue;

                        ary[newR][newC] = '*';
                        fire.add(new int[]{newR, newC, t+1});
                    }
                }

                boolean move = false;
                boolean escape = false;
                while(!person.isEmpty())
                {
                    int[] tmp = person.peek();
                    if(tmp[2] != t)
                        break;

                    person.poll();

                    for(int k=0; k<4; k++)
                    {
                        int newR = tmp[0] + dr[k];
                        if(newR < 0 || newR >= h)
                        {
                            escape = true;
                            break;
                        }

                        int newC = tmp[1] + dc[k];
                        if(newC < 0 || newC >= w)
                        {
                            escape = true;
                            break;
                        }

                        if(ary[newR][newC] == '#' || ary[newR][newC] == '*' || ary[newR][newC] == '@')
                            continue;

                        move = true;
                        ary[newR][newC] = '@';
                        person.add(new int[]{newR, newC, t+1});
                    }
                }

                if(escape)
                {
                    sb.append(t).append('\n');
                    break;
                }
                else if(!move)
                {
                    sb.append("IMPOSSIBLE\n");
                    break;
                }

                t++;
            }
        }

        System.out.print(sb.toString());
    }
}
