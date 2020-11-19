/*
구슬 탈출 2

https://www.acmicpc.net/problem/13460
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-19
 * Time: 오전 12:18
 */

public class Q13460
{
    static int N;
    static int M;
    static char[][] ary = new char[11][11];
    static int bit = 0;
    static int min = Integer.MAX_VALUE;

    public static boolean promise(int index, int dir)
    {
        if(index > 0)
        {
            int prevDir = bit & (3 << (2 * (index - 1)));

            // 같은 방향으로 기울이면 false
            if(dir == prevDir)
                return false;
            // 반대 방향으로 기울이면 false
            if((3 - dir) == prevDir)
                return false;
        }

        return true;
    }

    public static void foo(int index)
    {
        for(int dir = 0; dir < 4; dir++)
        {
            if(promise(index, dir))
            {
                if(index == 10)
                {
                    int cnt = 0;

                    int checking = 3;
                    for(int i=0; i<10; i++)
                    {
                        int checking2 = checking << (2*i);

                        int curDir = bit & checking2;
                    }
                }

                // 방향 마킹
                bit |= (dir << 2*index);
                foo(index+1);
                // 방향 제거
                bit &= ~(dir << 2*index);
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<M; j++)
                ary[i][j] = str.charAt(j);
        }


    }
}
