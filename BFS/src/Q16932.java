/*
모양 만들기

https://www.acmicpc.net/problem/16932
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-16
 * Time: 오후 5:41
 */

public class Q16932
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[1001][1001];

        for(int i=0; i<N; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<M; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {0, -1, 1, 0};
        int[] dc = {-1, 0, 0, 1};

        int[][] group = new int[1001][1001];
        int[] groupNum = new int[5000001];
        int gCnt = 0;

        // 그룹화
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                // 아직 들르지 않았으면 들른다.
                if(ary[i][j] != 0 && group[i][j] == 0)
                {
                    queue.add(new int[]{i, j});
                    group[i][j] = ++gCnt;

                    int cnt = 1;
                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int k=0; k<4; k++)
                        {
                            int newRow = tmp[0] + dr[k];
                            if(newRow < 0 || newRow >= N)
                                continue;
                            int newCol = tmp[1] + dc[k];
                            if(newCol < 0 || newCol >= M)
                                continue;

                            // 0이거나 이미 들렀으면 다음 방향 진행
                            if(ary[newRow][newCol] == 0 || group[newRow][newCol] != 0)
                                continue;

                            queue.add(new int[]{newRow, newCol});
                            group[newRow][newCol] = gCnt;
                            ++cnt;
                        }
                    }

                    groupNum[gCnt] = cnt;
                }
            }
        }

        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(ary[i][j] == 0)
                {
                    Set<Integer> set = new HashSet<>();

                    for(int k=0; k<4; k++)
                    {
                        int newRow = i + dr[k];
                        if(newRow < 0 || newRow >= N)
                            continue;
                        int newCol = j + dc[k];
                        if(newCol < 0 || newCol >= M)
                            continue;

                        // 네 방향의 그룹 번호를 넣는다.
                        set.add(group[newRow][newCol]);
                    }

                    int cnt = 1;
                    for(int num : set)
                        cnt += groupNum[num];

                    if(cnt > max)
                        max = cnt;
                }
            }
        }

        System.out.println(max);
    }
}
