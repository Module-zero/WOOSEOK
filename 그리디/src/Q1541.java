/*
잃어버린 괄호

https://www.acmicpc.net/problem/1541
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-20
 * Time: 오후 2:07
 */

public class Q1541
{
    static int[] ary = new int[25];
    static int aryId = 0;
    static char[] chAry = new char[25];
    static int chId = 0;

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        int num = 0;
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            if(ch == '+' || ch == '-')
            {
                ary[aryId++] = num;
                num = 0;
                chAry[chId++] = ch;
            }
            else
                num = 10*num + (ch - '0');
        }
        ary[aryId++] = num;

        int min = ary[0];
        int sum = 0;
        for(int i=1; i<aryId; i++)
        {
            if(chAry[i-1] == '-')
                sum += ary[i];
            // +
            else
            {
                // 앞에 -가 나왔던 적이 있으면 누적(괄호를 침)
                if(sum != 0)
                    sum += ary[i];
                // -가 나온 적이 없으면 바로 더한다.
                else
                    min += ary[i];
            }
        }
        min -= sum;

        System.out.println(min);
    }
}
