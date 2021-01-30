/*
나무 조각

https://www.acmicpc.net/problem/2947
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-30
 * Time: 오후 10:51
 */

public class Q2947
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[5];

        for(int i=0; i<5; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        StringBuffer sb = new StringBuffer();
        while(true)
        {
            boolean ok = true;

            for(int i=0; i<4; i++)
            {
                int j = i+1;

                if(ary[i] > ary[j])
                {
                    ok = false;

                    int tmp = ary[i];
                    ary[i] = ary[j];
                    ary[j] = tmp;

                    for(int k=0; k<5; k++)
                        sb.append(ary[k]).append(' ');

                    sb.append('\n');
                }
            }

            if(ok)
                break;
        }

        System.out.print(sb.toString());
    }
}
