/*
알고스팟

https://www.acmicpc.net/problem/1261
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-24
 * Time: 오후 8:27
 */

public class Q1261
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int[][] ary = new int[N+1][M+1];

        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j-1) - '0';
        }

        int[] dx = {1, 0, -1, 0};
        int[] dy = {0, 1, 0, -1};

        Deque<int[]> deque = new LinkedList<>();
        boolean[][] check = new boolean[N+1][M+1];

        // [0] : x, [1] : y, [2] : 벽을 부순 횟수
        deque.add(new int[]{1, 1, 0});
        check[1][1] = true;
        int cnt = 0;

        while(!deque.isEmpty())
        {
            int[] info = deque.peek();

            while(info[2] == cnt)
            {
                // 큐에서 제거
                deque.poll();

                // 도착했으면 벽을 부순 횟수 출력
                if(info[1] == N && info[0] == M)
                {
                    System.out.println(info[2]);
                    return;
                }

                for(int i=0; i<4; i++)
                {
                    int newX = info[0] + dx[i];
                    int newY = info[1] + dy[i];

                    // 범위에서 벗어나면 다음 방향
                    if(newX < 1 || newX > M)
                        continue;
                    if(newY < 1 || newY > N)
                        continue;

                    // 이미 간 길인지 체크
                    if(!check[newY][newX])
                    {
                        // 벽이 아니면 그대로 전진
                        if(ary[newY][newX] == 0)
                        {
                            deque.addFirst(new int[]{newX, newY, cnt});
                            check[newY][newX] = true;
                        }
                        // 벽이면 벽을 부수고 전진
                        else
                        {
                            deque.addLast(new int[]{newX, newY, cnt+1});
                            check[newY][newX] = true;
                        }
                    }
                }

                info = deque.peek();
            }

            cnt++;
        }
    }
}
