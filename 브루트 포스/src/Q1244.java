/*
스위치 켜고 끄기

https://www.acmicpc.net/problem/1244
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-02-03
 * Time: 오후 7:43
 */

public class Q1244
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int sw = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] ary = new int[101];
        for(int i=1; i<=sw; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int sd = Integer.parseInt(br.readLine());
        for(int i=0; i<sd; i++)
        {
            st = new StringTokenizer(br.readLine());
            int gender = Integer.parseInt(st.nextToken());
            int num = Integer.parseInt(st.nextToken());

            // 남자
            if(gender == 1)
            {
                for(int j=num; j<=sw; j+=num)
                    ary[j] = 1 - ary[j];
            }
            // 여자
            else
            {
                int si = num;
                int ei = num;
                while(si-1 >= 1 && ei+1 <= sw)
                {
                    if(ary[si-1] == ary[ei+1])
                    {
                        si = si-1;
                        ei = ei+1;
                    }
                    else
                        break;
                }

                for(int j=si; j<=ei; j++)
                    ary[j] = 1 - ary[j];
            }
        }

        StringBuffer sb = new StringBuffer();
        for(int i=1; i<=sw; i++)
        {
            if(i != 1 && i % 20 == 1)
                sb.append('\n');

            sb.append(ary[i]).append(' ');
        }

        System.out.println(sb.toString());
    }
}
