/*
탈옥

https://www.acmicpc.net/problem/9376
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
 * Date: 2020-11-17
 * Time: 오후 3:15
 */

public class Q9376
{
    static int h;
    static int w;
    static char[][] ary = new char[101][101];
    static int[][] criminal = new int[2][2];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    public static void bfs()
    {

    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());

        Queue<int[]> queue = new LinkedList<>();
        while(tc-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            int cCnt = 0;

            for(int i=0; i<h; i++)
            {
                String str = br.readLine();

                for(int j=0; j<w; j++)
                {
                    ary[i][j] = str.charAt(j);

                    // 수감자 위치 저장
                    if(ary[i][j] == '$')
                    {
                        criminal[cCnt][0] = i;
                        criminal[cCnt][1] = j;
                        cCnt++;
                    }
                }
            }

            int[][] check = new int[101][101];
            for(int i=0; i<h; i++)
            {
                for(int j=0; j<w; j++)
                    check[i][j] = -1;
            }

            queue.add(new int[]{criminal[0][0], criminal[0][1]});

            while(!queue.isEmpty())
            {
                int[] tmp = queue.poll();

                for(int i=0; i<4; i++)
                {
                    int newRow = tmp[0] + dr[i];
                    if(newRow < 0 || newRow >= h)
                        continue;
                    int newCol = tmp[1] + dc[i];
                    if(newCol < 0 || newCol >= w)
                        continue;

                    if(ary[newRow][newCol] == '*')
                    {

                    }
                }
            }

            queue.add(new int[]{criminal[1][0], criminal[1][1]});
        }
    }
}
