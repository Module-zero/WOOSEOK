/*
배열에서 이동

https://www.acmicpc.net/problem/1981
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
 * Date: 2020-12-07
 * Time: 오후 10:28
 */

public class Q1981
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] ary = new int[101][101];
        for(int i=0; i<n; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<n; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        int[] dr = {-1, 0, 0, 1};
        int[] dc = {0, -1, 1, 0};

        int start = 0;
        int end = 200;

        int min = 0;
        // 이분탐색 시작
        while(start <= end)
        {
            // 최댓값과 최솟값의 차이를 정한다.
            int mid = (start + end) / 2;
            boolean isFound = false;

            // num : 최솟값, num+mid : 최댓값
            for(int num=0; num+mid<=200; num++)
            {
                boolean[][] check = new boolean[101][101];
                // 범위를 넘어서면 다음 최소~최대로
                if(ary[0][0] < num || ary[0][0] > num+mid)
                    continue;

                // BFS 탐색 시작
                Queue<int[]> queue = new LinkedList<>();
                queue.add(new int[]{0, 0});
                check[0][0] = true;
                while(!queue.isEmpty())
                {
                    int[] tmp = queue.poll();
                    int r = tmp[0];
                    int c = tmp[1];

                    for(int i=0; i<4; i++)
                    {
                        int newR = r + dr[i];
                        if(newR < 0 || newR >= n)
                            continue;
                        int newC = c + dc[i];
                        if(newC < 0 || newC >= n)
                            continue;

                        if(check[newR][newC] || ary[newR][newC] < num || ary[newR][newC] > num+mid)
                            continue;

                        // 목적지까지 도착했으면 탐색 종료
                        if(newR == n-1 && newC == n-1)
                        {
                            isFound = true;
                            break;
                        }

                        check[newR][newC] = true;
                        queue.add(new int[]{newR, newC});
                    }

                    if(isFound)
                        break;
                }

                if(isFound)
                {
                    min = mid;
                    end = mid - 1;
                    break;
                }
            }

            if(!isFound)
                start = mid + 1;
        }

        System.out.println(min);
    }
}
