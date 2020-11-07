/*
N-Queen

https://www.acmicpc.net/problem/9663
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 8:50
 */

public class Q9663
{
    static int N;
    static int cnt = 0;
    static int[] ary = new int[15];

    public static boolean check(int row)
    {
        for(int i=0; i<row; i++)
        {
            // 같은 열에 놓이면 안됨
            if(ary[i] == ary[row])
                return false;

            int diagonal = ary[row] - ary[i];
            if(diagonal < 0)
                diagonal = -diagonal;

            // 대각선 상에 놓이면 안됨
            if(diagonal == row-i)
                return false;
        }

        return true;
    }

    public static void foo(int row)
    {
        if(row == N)
        {
            cnt++;
            return;
        }

        // 열 하나에 퀸을 놓는다.
        for(int col=0; col<N; col++)
        {
            ary[row] = col;
            if(check(row))
                foo(row+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        foo(0);

        System.out.println(cnt);
    }
}
