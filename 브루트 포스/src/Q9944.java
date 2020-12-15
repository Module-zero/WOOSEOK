/*
NxM 보드 완주하기

https://www.acmicpc.net/problem/9944
 */

import java.io.BufferedReader;
import java.io.EOFException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-20
 * Time: 오후 3:31
 */

public class Q9944
{
    static int N;
    static int M;
    static int[] dr = {-1, 0, 0, 1};
    static int[] dc = {0, -1, 1, 0};
    static int min;

    public static boolean isAnswer(char[][] ary, int[][] check)
    {
        for(int i=0; i<N; i++)
        {
            for(int j=0; j<M; j++)
            {
                if(ary[i][j] == '*')
                    continue;

                if(check[i][j] == 0)
                    return false;
            }
        }

        return true;
    }

    public static void dfs(char[][] ary, int r, int c, int[][] check)
    {
        boolean isEnd = true;

        for(int i=0; i<4; i++)
        {
            int newR = r;
            int newC = c;

            while(true)
            {
                int tmpR = newR = dr[i];
                if(tmpR < 0 || tmpR >= N)
                    break;

                int tmpC = newC = dc[i];
                if(tmpC < 0 || tmpC >= M)
                    break;

                if(ary[tmpR][tmpC] == '*' || check[tmpR][tmpC] != 0)
                    break;

                newR = tmpR;
                newC = tmpC;
            }

            if(newR == r && newC == c)
                continue;

            // 사방이 막히지 않음
            isEnd = false;
        }

        // 모든 칸을 다 돌았는지 검사한다.
        if(isEnd)
        {
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            String value = br.readLine();
            if(value == null)
                return;

            min = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(value);

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            char[][] ary = new char[31][31];

            for(int i=0; i<N; i++)
            {
                String str = br.readLine();

                for(int j=0; j<M; j++)
                    ary[i][j] = str.charAt(j);
            }

            for(int i=0; i<N; i++)
            {
                for(int j=0; j<M; j++)
                {
                    // 장애물이면 공을 놓을 수 없다.
                    if(ary[i][j] == '*')
                        continue;

                    int[][] check = new int[31][31];
                }
            }
        }
    }
}
