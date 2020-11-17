/*
성곽

https://www.acmicpc.net/problem/2234
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
 * Date: 2020-11-16
 * Time: 오후 9:54
 */

public class Q2234
{
    static int n;
    static int m;
    static int[][] ary = new int[51][51];
    static int[] dr = {0, -1, 0, 1};
    static int[] dc = {-1, 0, 1, 0};

    public static void count()
    {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[51][51];

        int cnt = 0;
        int max = 0;
        int[][] group = new int[51][51];
        // 최대 2500개의 그룹
        int[] groupNum = new int[2501];

        for(int i=0; i<m; i++)
        {
            for(int j=0; j<n; j++)
            {
                // 아직 들르지 않았으면 탐색
                if(!check[i][j])
                {
                    int area = 1;
                    queue.add(new int[]{i, j});
                    check[i][j] = true;
                    cnt++;
                    group[i][j] = cnt;
                    groupNum[cnt]++;

                    while(!queue.isEmpty())
                    {
                        int[] tmp = queue.poll();

                        for(int bit=1, k=0; bit<16; bit<<=1, k++)
                        {
                            // 가려는 방향이 벽으로 막혀있으면 다음 방향
                            if((ary[tmp[0]][tmp[1]] & bit) != 0)
                                continue;

                            int newRow = tmp[0] + dr[k];
                            if(newRow < 0 || newRow >= m)
                                continue;

                            int newCol = tmp[1] + dc[k];
                            if(newCol < 0 || newCol >= n)
                                continue;

                            // 이미 들렀으면 다음 방향
                            if(check[newRow][newCol])
                                continue;

                            queue.add(new int[]{newRow, newCol});
                            // 방문처리
                            check[newRow][newCol] = true;
                            // 넓이에 1 더한다.
                            area++;
                            // 그룹을 매핑하고 총 그룹원 수에 1 더한다.
                            group[newRow][newCol] = cnt;
                            groupNum[cnt]++;
                        }
                    }

                    // 가장 넓은 방의 넓이
                    if(max < area)
                        max = area;
                }
            }
        }

        int destWall = 0;
        for(int i=0; i<=m-1; i++)
        {
            for(int j=0; j<=n-1; j++)
            {
                // 인접한 칸이 서로 다른 그룹일 경우 벽을 허물면 합쳐지므로 더한다.
                if(group[i][j] != group[i+1][j])
                {
                    int sum = groupNum[group[i][j]] + groupNum[group[i+1][j]];

                    if(destWall < sum)
                        destWall = sum;
                }

                if(group[i][j] != group[i][j+1])
                {
                    int sum = groupNum[group[i][j]] + groupNum[group[i][j+1]];

                    if(destWall < sum)
                        destWall = sum;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append('\n').append(max).append('\n').append(destWall);

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for(int i=0; i<m; i++)
        {
            st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        count();
    }
}
