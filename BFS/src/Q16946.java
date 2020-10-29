/*
벽 부수고 이동하기 4

https://www.acmicpc.net/problem/16946
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-29
 * Time: 오전 12:06
 */

public class Q16946
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[][] ary = new int[N+1][M+1];
        for(int i=1; i<=N; i++)
        {
            String str = br.readLine();

            for(int j=1; j<=M; j++)
                ary[i][j] = str.charAt(j-1) - '0';
        }

        Queue<int[]> queue = new LinkedList<>();
        // 그룹짓는다.
        boolean[][] check = new boolean[1001][1001];
        int[][] group = new int[1001][1001];
        int[] gCnt = new int[501001];
        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        int groupNum = 0;
        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                // 뚫린 길이면 이어진 길을 탐색해서 그룹 번호를 매긴다.
                int cnt = 0;
                if(ary[i][j] == 0 && !check[i][j])
                {
                    // 그룹 번호를 하나 증가시킨다.
                    groupNum++;

                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                    group[i][j] = groupNum;
                    cnt++;

                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int k=0; k<4; k++)
                        {
                            int newRow = tmp[0] + dr[k];
                            if(newRow < 1 || newRow > N)
                                continue;
                            int newCol = tmp[1] + dc[k];
                            if(newCol < 1 || newCol > M)
                                continue;

                            if(ary[newRow][newCol] == 0 && !check[newRow][newCol])
                            {
                                cnt++;
                                check[newRow][newCol] = true;
                                group[newRow][newCol] = groupNum;
                                queue.add(new int[]{newRow, newCol});
                            }
                        }
                    }

                    gCnt[groupNum] = cnt;
                }
            }
        }

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
            {
                // 주변을 탐색해서 마주하는 변에 몇 번 그룹이 있는지 찾는다.
                if(ary[i][j] == 1)
                {
                    TreeSet<Integer> set = new TreeSet<>();
                    for(int k=0; k<4; k++)
                    {
                        int newRow = i + dr[k];
                        if(newRow < 1 || newRow > N)
                            continue;
                        int newCol = j + dc[k];
                        if(newCol < 1 || newCol > M)
                            continue;

                        // 겹치지 않게 set에 그룹 번호를 넣는다.
                        set.add(group[newRow][newCol]);
                    }

                    // 주변에 있는 칸의 개수를 센다.
                    int cnt = 1;
                    for(int num : set)
                        cnt += gCnt[num];

                    ary[i][j] = cnt % 10;
                }
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=1; i<=N; i++)
        {
            for(int j=1; j<=M; j++)
                sb.append(ary[i][j]);
            sb.append("\n");
        }

        System.out.print(sb.toString());
    }
}
