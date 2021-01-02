/*
현수막

https://www.acmicpc.net/problem/14716
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
 * Date: 2020-12-27
 * Time: 오후 2:55
 */

public class Q14716
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] ary = new int[251][251];
        for(int i=0; i<M; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dc = {-1, 0, 1, -1, 0, 1, -1, 0, 1};

        int ans = 0;
        int[][] group = new int[251][251];
        int gNum = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<M; i++)
        {
            for(int j=0; j<N; j++)
            {
                if(group[i][j] == 0)
                {
                    if(ary[i][j] == 1)
                        ans++;

                    queue.add(new int[]{i, j});
                    group[i][j] = ++gNum;

                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int k=0; k<9; k++)
                        {
                            int newR = tmp[0] + dr[k];
                            if(newR < 0 || newR >= M)
                                continue;

                            int newC = tmp[1] + dc[k];
                            if(newC < 0 || newC >= N)
                                continue;

                            if(ary[tmp[0]][tmp[1]] == ary[newR][newC] && group[newR][newC] == 0)
                            {
                                group[newR][newC] = gNum;
                                queue.add(new int[]{newR, newC});
                            }
                        }
                    }
                }
            }
        }

        System.out.println(ans);
    }
}
