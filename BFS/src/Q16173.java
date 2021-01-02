/*
점프왕 쩰리 (Small)

https://www.acmicpc.net/problem/16173
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
 * Time: 오후 2:33
 */

public class Q16173
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] ary = new int[4][4];
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        // 오른쪽과 아래
        int[] dr = {0, 1};
        int[] dc = {1, 0};
        boolean[][] check = new boolean[4][4];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        check[0][0] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            // 오른쪽과 아래쪽으로 이동
            for(int k=0; k<2; k++)
            {
                int num = ary[tmp[0]][tmp[1]];

                int newR = tmp[0];
                int newC = tmp[1];
                while(num-- > 0)
                {
                    newR += dr[k];
                    if(newR < 0 || newR >= N)
                        break;

                    newC += dc[k];
                    if(newC < 0 || newC >= N)
                        break;
                }

                if(num == -1)
                {
                    if(newR == N-1 && newC == N-1)
                    {
                        System.out.println("HaruHaru");
                        return;
                    }

                    if(!check[newR][newC])
                    {
                        queue.add(new int[]{newR, newC});
                        check[newR][newC] = true;
                    }
                }
            }
        }

        System.out.println("Hing");
    }
}
