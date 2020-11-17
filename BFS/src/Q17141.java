/*
연구소 2

https://www.acmicpc.net/problem/17141
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-17
 * Time: 오후 2:17
 */

public class Q17141
{
    static int N;
    static int M;
    static int[][] ary = new int[51][51];
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int min = Integer.MAX_VALUE;

    // 바이러스를 놓거나 안놓거나
    public static void foo(int index, int cnt)
    {
        // 2의 개수만큼 돌았을 때
        if(index == list.size())
        {
            // 바이러스를 M개 놓았다면 진행
            if(cnt == M)
            {
                int ret = bfs();

                // 바이러스가 퍼지지 않은 빈 칸이 없었으면
                if(ret != -1 && ret < min)
                    min = ret;
            }

            return;
        }

        int[] tmp = list.get(index);

        // 바이러스를 놓고 다음으로
        ary[tmp[0]][tmp[1]] = 3;
        foo(index + 1, cnt + 1);

        // 바이러스를 놓지 않고 다음으로
        ary[tmp[0]][tmp[1]] = 2;
        foo(index + 1, cnt);
    }

    public static int bfs()
    {
        // 시간을 재기 위한 배열 선언
        int[][] sec = new int[51][51];

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                sec[i][j] = -1;
        }

        Queue<int[]> queue = new LinkedList<>();

        for(int i=0; i<list.size(); i++)
        {
            int[] tmp = list.get(i);

            // 바이러스를 놓았으면 퍼트리기 위해 큐에 넣는다.
            if(ary[tmp[0]][tmp[1]] == 3)
            {
                sec[tmp[0]][tmp[1]] = 0;
                queue.add(new int[]{tmp[0], tmp[1]});
            }
        }

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            for(int i=0; i<4; i++)
            {
                int newRow = tmp[0] + dr[i];
                if(newRow < 0 || newRow >= N)
                    continue;

                int newCol = tmp[1] + dc[i];
                if(newCol < 0 || newCol >= N)
                    continue;

                // 이미 들렀거나 벽이면 다음 방향으로 진행
                if(sec[newRow][newCol] != -1 || ary[newRow][newCol] == 1)
                    continue;

                // 퍼진 바이러스는 4
                ary[newRow][newCol] = 4;
                queue.add(new int[]{newRow, newCol});
                sec[newRow][newCol] = sec[tmp[0]][tmp[1]] + 1;
            }
        }

        int max = 0;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                // 빈 칸에 퍼졌던 바이러스라면 다시 빈 칸으로
                if(ary[i][j] == 4)
                {
                    ary[i][j] = 0;
                    // 바이러스가 퍼진 시간이 가장 큰 칸이 가장 나중에 퍼진 칸
                    if(sec[i][j] > max && max != -1)
                        max = sec[i][j];
                }
                // 바이러스가 퍼지지 않았던 빈 칸이 있으면 -1
                else if(ary[i][j] == 0)
                    max = -1;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
            {
                ary[i][j] = Integer.parseInt(st.nextToken());
                // 바이러스를 놓을 수 있으면 위치 저장
                if(ary[i][j] == 2)
                    list.add(new int[]{i, j});
            }
        }

        foo(0, 0);

        // 모든 빈 칸에 바이러스를 퍼트릴 수 없으면 -1 출력
        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}
