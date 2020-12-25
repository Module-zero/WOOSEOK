/*
인구 이동

https://www.acmicpc.net/problem/16234
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
 * Date: 2020-12-25
 * Time: 오후 5:29
 */

public class Q16234
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] ary = new int[51][51];
        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};
        int ans = 0;
        while(true)
        {
            Queue<int[]> queue = new LinkedList<>();
            int[][] group = new int[51][51];
            int[] gCnt = new int[2501];
            int[] gPerson = new int[2501];
            int gNum = 0;

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    if(group[i][j] == 0)
                    {
                        queue.add(new int[]{i, j});
                        group[i][j] = ++gNum;
                        gPerson[gNum] += ary[i][j];
                        gCnt[gNum]++;

                        while(!queue.isEmpty())
                        {
                            int[] tmp = queue.poll();

                            for(int k=0; k<4; k++)
                            {
                                int newR = tmp[0] + dr[k];
                                if(newR < 0 || newR >= N)
                                    continue;

                                int newC = tmp[1] + dc[k];
                                if(newC < 0 || newC >= N)
                                    continue;

                                if(group[newR][newC] != 0)
                                    continue;

                                int diff = Math.abs(ary[tmp[0]][tmp[1]] - ary[newR][newC]);
                                if(diff >= L && diff <= R)
                                {
                                    group[newR][newC] = gNum;
                                    gPerson[gNum] += ary[newR][newC];
                                    gCnt[gNum]++;
                                    queue.add(new int[]{newR, newC});
                                }
                            }
                        }
                    }
                }
            }

            boolean ok = false;
            for(int i=0; i<N; i++)
            {
                for(int j=0; j<N; j++)
                {
                    int g = group[i][j];
                    if(gCnt[g] > 1)
                    {
                        ary[i][j] = gPerson[g] / gCnt[g];
                        ok = true;
                    }
                }
            }

            if(!ok)
                break;

            ans++;
        }

        System.out.println(ans);
    }
}
