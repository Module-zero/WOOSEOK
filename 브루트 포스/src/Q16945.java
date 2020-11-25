/*
매직 스퀘어로 변경하기

https://www.acmicpc.net/problem/16945
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-25
 * Time: 오후 4:40
 */

public class Q16945
{
    static int[][] ary = new int[3][3];
    static boolean[] check = new boolean[10];
    static int min = Integer.MAX_VALUE;
    static int[] row = new int[3];
    static int[] col = new int[3];
    static int[] dia = new int[2];

    public static boolean promise()
    {
        for(int i=0; i<3; i++)
        {
            if(row[i] != 15)
                return false;
            if(col[i] != 15)
                return false;
            if(i != 2 && dia[i] != 15)
                return false;
        }

        return true;
    }

    public static void foo(int index, int sum)
    {
        if(index == 9)
        {
            if(promise())
            {
                if(sum < min)
                    min = sum;
            }

            return;
        }

        int rId = index%3;
        int cId = index/3;
        for(int num=1; num<=9; num++)
        {
            if(!check[num])
            {
                check[num] = true;
                int tmp = ary[rId][cId];
                ary[rId][cId] = num;
                row[rId] += num;
                col[cId] += num;

                // 오른쪽 아래방향 대각선
                if(rId == cId)
                    dia[0] += num;
                // 왼쪽 아래방향 대각선
                if(rId + cId == 2)
                    dia[1] += num;

                foo(index+1, sum + Math.abs(num - tmp));

                if(rId == cId)
                    dia[0] -= num;
                if(rId + cId == 2)
                    dia[1] -= num;

                col[cId] -= num;
                row[rId] -= num;
                ary[rId][cId] = tmp;
                check[num] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int i=0; i<3; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            for(int j=0; j<3; j++)
                ary[i][j] = Integer.parseInt(st.nextToken());
        }

        foo(0, 0);

        System.out.println(min);
    }
}
