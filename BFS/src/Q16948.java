/*
데스 나이트

https://www.acmicpc.net/problem/16948
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
 * Date: 2020-10-28
 * Time: 오후 2:26
 */

public class Q16948
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] dr = {-2, -2, 0, 0, 2, 2};
        int[] dc = {-1, 1, -2, 2, -1, 1};

        int N = Integer.parseInt(br.readLine());
        boolean[][] check = new boolean[N][N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        // [0], [1] : 시작 지점 || [2], [3] : 도착 지점
        int[] location = new int[4];
        for(int i=0; i<4; i++)
            location[i] = Integer.parseInt(st.nextToken());

        int cnt = 0;
        Queue<int[]> queue = new LinkedList<>();
        // [0] : row, [1] : col, [2] : cnt
        queue.add(new int[]{location[0], location[1], cnt});

        while(!queue.isEmpty())
        {
            int[] info = queue.peek();

            while(!queue.isEmpty() && info[2] == cnt)
            {
                queue.poll();

                for(int i=0; i<6; i++)
                {
                    // 이동한 좌표
                    int newRow = info[0] + dr[i];
                    if(newRow < 0 || newRow >= N)
                        continue;
                    int newCol = info[1] + dc[i];
                    if(newCol < 0 || newCol >= N)
                        continue;

                    // 정답이면 횟수 출력 후 종료
                    if(newRow == location[2] && newCol == location[3])
                    {
                        System.out.println(info[2] + 1);
                        return;
                    }

                    if(!check[newRow][newCol])
                    {
                        check[newRow][newCol] = true;

                        queue.add(new int[]{newRow, newCol, info[2]+1});
                    }
                }

                info = queue.peek();
            }

            cnt++;
        }

        System.out.println("-1");
    }
}
