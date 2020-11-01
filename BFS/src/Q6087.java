/*
레이저 통신

https://www.acmicpc.net/problem/6087
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
 * Date: 2020-10-31
 * Time: 오후 9:35
 */

public class Q6087
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        char[][] ary = new char[100][100];
        int[][] rc = new int[2][2];
        int[][] cnt = new int[100][100];
        for(int i=0; i<H; i++)
        {
            for(int j=0; j<W; j++)
                cnt[i][j] = -1;
        }

        // C의 위치를 저장할 인덱스
        int id = 0;
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        for(int i=0; i<H; i++)
        {
            String str = br.readLine();
            for(int j=0; j<W; j++)
            {
                ary[i][j] = str.charAt(j);
                // 레이저 위치를 저장한다.
                if(ary[i][j] == 'C')
                {
                    rc[id][0] = i;
                    rc[id][1] = j;
                    id++;
                }
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        // [0], [1] : index, [2] : 거울의 개수
        queue.add(new int[]{rc[0][0], rc[0][1], 0});
        cnt[rc[0][0]][rc[0][1]] = 0;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0];
                int newCol = tmp[1];

                while(true)
                {
                    // 일직선으로 쭉 가면서 큐에 넣는다.
                    newRow += dr[i];
                    if (newRow < 0 || newRow >= H)
                        break;
                    newCol += dc[i];
                    if (newCol < 0 || newCol >= W)
                        break;

                    // 들른 곳인데 현재 거울을 놓은 개수보다 같거나 작았으면 다시 들를 필요가 없으므로 break
                    if (cnt[newRow][newCol] != -1 && cnt[newRow][newCol] <= tmp[2])
                        break;
                    // 벽을 만나면 직진할 수 없음
                    if(ary[newRow][newCol] == '*')
                        break;

                    // C에 도착했으면 종료
                    if(newRow == rc[1][0] && newCol == rc[1][1])
                    {
                        System.out.println(tmp[2]);
                        return;
                    }

                    queue.add(new int[]{newRow, newCol, tmp[2] + 1});
                    cnt[newRow][newCol] = tmp[2] + 1;
                }
            }
        }
    }
}
