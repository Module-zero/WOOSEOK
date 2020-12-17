/*
삼각형의 값

https://www.acmicpc.net/problem/4902
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-16
 * Time: 오후 5:37
 */

public class Q4902
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer();
        int tc = 1;
        while(true)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            if(num == 0)
                break;

            int max = Integer.MIN_VALUE;
            int k=1;
            int[][] ary = new int[401][401];
            for(int i=0; i<num; i++)
            {
                for(int j=0; j<k; j++)
                    ary[i][j] = Integer.parseInt(st.nextToken());

                k += 2;
            }

            for(int size=1; size<=num; size++)
            {

            }

            sb.append(tc).append('.').append(' ').append(max).append('\n');
            tc++;
        }

        System.out.print(sb.toString());
    }
}
