/*
연구소 3

https://www.acmicpc.net/problem/17142
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
 * Date: 2020-11-25
 * Time: 오전 10:53
 */

public class Q17142
{
    static int N;
    static int M;
    static int[][] ary = new int[51][51];
    static ArrayList<int[]> virus = new ArrayList<>();
    static boolean[] check = new boolean[10];
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int min = Integer.MAX_VALUE;

    public static void foo(int index, int cnt)
    {
        if(index == virus.size())
        {
            // 활성 바이러스를 모두 놓았으면 퍼트린다.
            if(cnt == M)
                bfs();

            return;
        }

        // 활성 바이러스
        int[] location = virus.get(index);
        ary[location[0]][location[1]] = 3;
        check[index] = true;

        // 다음 바이러스 위치로
        foo(index+1, cnt+1);

        // 다시 비활성화
        ary[location[0]][location[1]] = 2;
        check[index] = false;
        foo(index+1, cnt);
    }

    public static void bfs()
    {
        int[][] dist = new int[51][51];
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
                dist[i][j] = -1;
        }

        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<virus.size(); i++)
        {
            if(check[i])
            {
                queue.add(virus.get(i));
                dist[virus.get(i)[0]][virus.get(i)[1]] = 0;
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

                // 이미 들렀으면 continue || 벽이면 continue
                if(dist[newRow][newCol] != -1 || ary[newRow][newCol] == 1)
                    continue;

                queue.add(new int[]{newRow, newCol});

                dist[newRow][newCol] = dist[tmp[0]][tmp[1]] + 1;
            }
        }

        int max = 0;

        for(int i=0; i<N; i++)
        {
            for(int j=0; j<N; j++)
            {
                // 벽이면 넘어간다. || 비활성화 바이러스면 넘어간다.(이미 바이러스이기 때문에)
                if(ary[i][j] == 1 || ary[i][j] == 2)
                    continue;

                if(ary[i][j] == 0 && dist[i][j] == -1)
                    return;

                if(dist[i][j] > max)
                    max = dist[i][j];
            }
        }

        if(max < min)
            min = max;
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

                // 바이러스 위치 기록
                if(ary[i][j] == 2)
                    virus.add(new int[]{i, j});
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        foo(0, 0);

        if(min == Integer.MAX_VALUE)
            min = -1;

        System.out.println(min);
    }
}
