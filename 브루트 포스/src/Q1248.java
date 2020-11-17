/*
맞춰봐

https://www.acmicpc.net/problem/1248
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-25
 * Time: 오후 8:59
 */

public class Q1248
{
    static int N;
    static char[][] ary = new char[11][11];
    static int[][] sum = new int[11][11];
    static boolean isFound = false;

    public static boolean promise(int index)
    {
        if(isFound)
            return false;

        for(int id=1; id<=index; id++)
        {
            switch(ary[id][index])
            {
                case '+':
                    if(sum[id][index] <= 0)
                        return false;
                    break;
                case '0':
                    if(sum[id][index] != 0)
                        return false;
                    break;
                case '-':
                    if(sum[id][index] >= 0)
                        return false;
                    break;
            }
        }

        return true;
    }

    public static void foo(int index)
    {
        if(index > N)
        {
            StringBuilder sb = new StringBuilder();

            for(int i=1; i<=N; i++)
                sb.append(sum[i][i]).append(' ');
            System.out.println(sb.toString());

            isFound = true;

            return;
        }

        for(int n = -10; n <= 10; n++)
        {
            for(int id=1; id<=index; id++)
                sum[id][index] = sum[id][index-1] + n;

            if(promise(index))
                foo(index+1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        int k = 0;
        for(int i=1; i<=N; i++)
        {
            for(int j=i; j<=N; j++)
                ary[i][j] = str.charAt(k++);
        }

        foo(0);
    }
}
