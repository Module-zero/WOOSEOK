/*
적어도 대부분의 배수

https://www.acmicpc.net/problem/1145
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 8:17
 */

public class Q1145
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[5];
        for(int i=0; i<5; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        for(int i=1; i<=1000000; i++)
        {
            int cnt = 0;
            for(int j=0; j<5; j++)
            {
                if(i % ary[j] == 0)
                    cnt++;
            }

            if(cnt >= 3)
            {
                System.out.println(i);
                return;
            }
        }
    }
}
