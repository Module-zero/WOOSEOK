/*
벽 부수고 이동하기 3

https://www.acmicpc.net/problem/16933
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
 * Date: 2020-11-03
 * Time: 오후 11:20
 */

public class Q16933
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] ary = new int[1001][1001];
        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j - 1) - '0';
        }

        // 도착점과 시작점이 같을 경우 아래 조건에서는 구분하기 번거로우므로 미리 종료시킨다.
        if(N == 1 && M == 1)
        {
            System.out.println("1");
            return;
        }

        // 벽 10개까지
        boolean[][][] check = new boolean[1001][1001][11];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        // [0], [1] : index, [2] : 벽 부순 횟수, [3] : 낮밤(첫 시작은 낮), [4] : 거리(시작 지점도 센다.)
        queue.add(new int[]{1, 1, 0, 0, 1});
        check[1][1][0] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0] + dr[i];
                if(newRow < 1 || newRow > N)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 1 || newCol > M)
                    continue;

                // 정답일 경우
                if(newRow == N && newCol == M)
                {
                    System.out.println(tmp[4] + 1);
                    return;
                }

                // 벽일 경우
                if(ary[newRow][newCol] == 1)
                {
                    // 벽을 더 이상 부술 수 없음
                    if(tmp[2] == K)
                        continue;

                    // 밤이면 낮이 될 때까지 기다린다.
                    if(tmp[3] == 1)
                        queue.add(new int[]{tmp[0], tmp[1], tmp[2], 0, tmp[4] + 1});
                    // 낮이면 전진
                    else
                    {
                        if(!check[newRow][newCol][tmp[2]+1])
                        {
                            // 밤이 됨
                            queue.add(new int[]{newRow, newCol, tmp[2] + 1, 1, tmp[4] + 1});
                            check[newRow][newCol][tmp[2] + 1] = true;
                        }
                    }
                }
                // 길일 경우 아직 들르지 않았으면 들른다.
                else if(!check[newRow][newCol][tmp[2]])
                {
                    // 낮밤이 바뀜
                    queue.add(new int[]{newRow, newCol, tmp[2], 1-tmp[3], tmp[4] + 1});
                    check[newRow][newCol][tmp[2]] = true;
                }
            }
        }

        System.out.println("-1");
    }
}
