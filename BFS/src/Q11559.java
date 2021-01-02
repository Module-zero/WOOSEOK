/*
Puyo Puyo

https://www.acmicpc.net/problem/11559
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-26
 * Time: 오후 6:40
 */

public class Q11559
{
    static char[][] ary = new char[13][7];

    public static void moveDown()
    {
        for(int j=0; j<6; j++)
        {
            for(int i=1; i<12; i++)
            {
                // 빈 칸이 아니라면
                if(ary[i][j] != '.')
                {
                    // 아래로 떨어뜨린다.
                    int ti = i;
                    while(ti > 0 && ary[ti-1][j] == '.')
                    {
                        ary[ti-1][j] = ary[ti][j];
                        ary[ti][j] = '.';
                        ti--;
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=11; i>=0; i--)
        {
            String str = br.readLine();

            for(int j=0; j<6; j++)
                ary[i][j] = str.charAt(j);
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int ans = 0;

        while(true)
        {
            Queue<int[]> queue = new LinkedList<>();
            int gNum = 0;
            int[] gCnt = new int[100];
            int[][] group = new int[13][7];

            for(int i=0; i<12; i++)
            {
                for(int j=0; j<6; j++)
                {
                    if (ary[i][j] != '.' && group[i][j] == 0)
                    {
                        ++gNum;
                        group[i][j] = gNum;
                        gCnt[gNum]++;

                        queue.add(new int[]{i, j});
                        while(!queue.isEmpty())
                        {
                            int[] tmp = queue.poll();

                            for(int k=0; k<4; k++)
                            {
                                int newR = tmp[0] + dr[k];
                                if(newR < 0 || newR >= 12)
                                    continue;

                                int newC = tmp[1] + dc[k];
                                if(newC < 0 || newC >= 6)
                                    continue;

                                if(ary[newR][newC] != ary[tmp[0]][tmp[1]] || group[newR][newC] != 0)
                                    continue;

                                queue.add(new int[]{newR, newC});
                                group[newR][newC] = gNum;
                                gCnt[gNum]++;
                            }
                        }
                    }
                }
            }

            boolean ok = false;
            for(int i=0; i<12; i++)
            {
                for(int j=0; j<6; j++)
                {
                    int g = group[i][j];

                    if(gCnt[g] >= 4)
                    {
                        ok = true;
                        ary[i][j] = '.';
                    }
                }
            }

            if(!ok)
                break;

            moveDown();
            ans++;
        }

        System.out.println(ans);
    }
}
