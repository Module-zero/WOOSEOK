/*
톱니바퀴

https://www.acmicpc.net/problem/14891
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-24
 * Time: 오후 6:46
 */

public class Q14891
{
    static int K;
    static int[][] ary = new int[4][9];
    static boolean[] check;

    public static void foo(int num, int roll)
    {
        check[num] = true;

        int left = (ary[num][8] < 2 ? 6 + ary[num][8] : ary[num][8] - 2);
        int right = (ary[num][8] + 2) % 8;
        if(roll == 1)
            ary[num][8] = (ary[num][8] == 0 ? 7 : ary[num][8] - 1);
        else
            ary[num][8] = (ary[num][8] + 1) % 8;

        if(num > 0 && !check[num-1])
        {
            int tRight = (ary[num-1][8] + 2) % 8;

            if(ary[num-1][tRight] != ary[num][left])
                foo(num-1, roll == 1 ? -1 : 1);
        }

        if(num < 3 && !check[num+1])
        {
            int tLeft = (ary[num+1][8] < 2 ? 6 + ary[num+1][8] : ary[num+1][8] - 2);

            if(ary[num+1][tLeft] != ary[num][right])
                foo(num+1, roll == 1 ? -1 : 1);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<4; i++)
        {
            String str = br.readLine();

            for(int j=0; j<8; j++)
                ary[i][j] = str.charAt(j) - '0';
        }

        K = Integer.parseInt(br.readLine());
        for(int i=0; i<K; i++)
        {
            check = new boolean[4];

            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int roll = Integer.parseInt(st.nextToken());

            foo(num, roll);
        }

        int sum = 0;
        for(int i=0; i<4; i++)
        {
            if(ary[i][ary[i][8]] == 1)
                sum += (1 << i);
        }

        System.out.println(sum);
    }
}
