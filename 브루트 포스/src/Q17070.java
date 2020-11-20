/*
파이프 옮기기 1

https://www.acmicpc.net/problem/9944
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-20
 * Time: 오후 3:47
 */

public class Q17070
{
    static int N;
    static int[][] ary = new int[17][17];
    static int cnt = 0;

    public static boolean promise(int i, int j, int kind)
    {
        if(i >= N || j >= N)
            return false;

        if(ary[i][j] == 1)
            return false;

        // 대각선 방향으로 놓았으면 위와 왼쪽도 검사
        if(kind == 2)
        {
            if(ary[i-1][j] == 1 || ary[i][j-1] == 1)
                return false;
        }

        return true;
    }

    // kind : 0(가로), 1(세로), 2(대각선)
    public static void foo(int i, int j, int kind)
    {
        if(promise(i, j, kind))
        {
            if (i == N - 1 && j == N - 1)
            {
                cnt++;
                return;
            }

            // 대각선 방향은 모두 가능
            foo(i+1, j+1, 2);

            // 세로가 아니면 가로 방향이 가능
            if (kind != 1)
                foo(i, j+1, 0);
            // 가로가 아니면 세로 방향이 가능
            if (kind != 0)
                foo(i+1, j, 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<N; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(0, 1, 0);
        System.out.println(cnt);
    }
}
