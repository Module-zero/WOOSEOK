/*
새끼치기

https://www.acmicpc.net/problem/17291
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-22
 * Time: 오후 4:45
 */

public class Q17291
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] ary = new int[21];
        ary[1] = 1;
        ary[2] = 2;
        ary[3] = 4;
        int del = 0;
        for(int i=4; i<=N; i++)
        {
            ary[i] = 2 * ary[i-1];

            if(i % 2 == 0)
            {
                // 삭제될 벌레 수 : -3년까지 생성된 벌레 수 - 저번에 삭제된 벌레 수
                del = ary[i-3] - del;
                ary[i] -= del;
            }
        }

        System.out.println(ary[N]);
    }
}
