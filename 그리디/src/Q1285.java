/*
동전 뒤집기

https://www.acmicpc.net/problem/1285
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-03
 * Time: 오후 2:13
 */

public class Q1285
{
    static int N;
    static char[][] ary = new char[20][20];
    static int min = Integer.MAX_VALUE;

    public static void reverseRow(int index)
    {
        // 모든 행에 대한 뒤집는 행위 종료. 이제 열을 뒤집는다.
        if(index == N)
        {
            int sum = 0;

            for(int i=0; i<N; i++)
            {
                int cnt = 0;

                for(int j=0; j<N; j++)
                {
                    if(ary[j][i] == 'T')
                        cnt++;
                }

                if(cnt > N/2)
                    cnt = N - cnt;

                sum += cnt;
            }

            if(min > sum)
                min = sum;

            return;
        }

        // 이번 행을 뒤집지 않음
        reverseRow(index+1);

        // 이번 행을 뒤집음
        for(int i=0; i<N; i++)
            ary[index][i] = (ary[index][i] == 'T') ? 'H' : 'T';
        reverseRow(index+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();

            for(int j=0; j<N; j++)
                ary[i][j] = str.charAt(j);
        }

        reverseRow(0);

        System.out.println(min);
    }
}
