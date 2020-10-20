/*
부등호

https://www.acmicpc.net/problem/2529
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-20
 * Time: 오전 11:01
 */

public class Q2529
{
    static int k;
    static boolean[] check = new boolean[10];
    static int[] ary = new int[10];
    static char[] ies = new char[10];
    static long min = Long.MAX_VALUE;
    static String minStr;
    static long max = Long.MIN_VALUE;
    static String maxStr;

    public static void foo(int index)
    {
        if(index == k+1)
        {
            StringBuilder tmpSb = new StringBuilder();

            for(int i=0; i<=k; i++)
                tmpSb.append(ary[i]);

            long num = Long.parseLong(tmpSb.toString());
            if(num < min)
            {
                min = num;
                minStr = tmpSb.toString();
            }

            if(num > max)
            {
                max = num;
                maxStr = tmpSb.toString();
            }

            return;
        }

        for(int i=0; i<=9; i++)
        {
            if(check[i])
                continue;

            switch(ies[index])
            {
                case '>':
                    if(i < ary[index-1])
                    {
                        check[i] = true;
                        ary[index] = i;
                        foo(index+1);
                        check[i] = false;
                    }
                    break;
                case '<':
                    if(i > ary[index-1])
                    {
                        check[i] = true;
                        ary[index] = i;
                        foo(index+1);
                        check[i] = false;
                    }
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        k = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1; i<=k; i++)
            ies[i] = st.nextToken().charAt(0);

        for(int i=0; i<=9; i++)
        {
            check[i] = true;
            ary[0] = i;
            foo(1);
            check[i] = false;
        }

        System.out.println(maxStr + "\n" + minStr);
    }
}
