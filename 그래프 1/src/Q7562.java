/*
나이트의 이동

https://www.acmicpc.net/problem/7562
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
 * Date: 2020-10-21
 * Time: 오후 5:10
 */

public class Q7562
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while(tc-- > 0)
        {
            int l = Integer.parseInt(br.readLine());

            int[][] map = new int[l][l];
            boolean[][] check = new boolean[l][l];

            int[] cur = new int[2];
            int[] goal = new int[2];

            StringTokenizer st = new StringTokenizer(br.readLine());
            cur[0] = Integer.parseInt(st.nextToken());
            cur[1] = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            goal[0] = Integer.parseInt(st.nextToken());
            goal[1] = Integer.parseInt(st.nextToken());

            int[] dr = {-1, -2, -2, -1, 1, 2, 2, 1};
            int[] dc = {-2, -1, 1, 2, 2, 1, -1, -2};

            Queue<int[]> queue = new LinkedList<>();

            // 시작점에서 start
            queue.add(cur);
            check[cur[0]][cur[1]] = true;

            while(!queue.isEmpty())
            {
                int[] knight = queue.poll();
                if(knight[0] == goal[0] && knight[1] == goal[1])
                    break;

                for(int i=0; i<8; i++)
                {
                    int newRow = knight[0] + dr[i];
                    int newCol = knight[1] + dc[i];

                    if(newRow < 0 || newRow > l-1)
                        continue;
                    if(newCol < 0 || newCol > l-1)
                        continue;

                    if(!check[newRow][newCol])
                    {
                        // 현재 위치에서 1번 이동해야 하므로
                        map[newRow][newCol] = map[knight[0]][knight[1]] + 1;
                        check[newRow][newCol] = true;

                        queue.add(new int[]{newRow, newCol});
                    }
                }
            }

            sb.append(map[goal[0]][goal[1]] + "\n");
        }

        System.out.print(sb.toString());
    }
}
