/*
로또

https://www.acmicpc.net/problem/6603
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 8:56
 */

public class Q6603
{
    static int k;
    static int[] ary;
    static int[] tmp;
    static boolean[] check;
    static StringBuilder sb;

    public static void foo(int index, int start)
    {
        if(index == 6)
        {
            for(int i=0; i<6; i++)
                sb.append(tmp[i] + " ");

            sb.append("\n");
            return;
        }

        for(int i=start; i<k; i++)
        {
            if(check[i])
                continue;

            tmp[index] = ary[i];
            check[i] = true;
            foo(index+1, i+1);
            check[i] = false;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true)
        {
            sb = new StringBuilder();

            StringTokenizer st = new StringTokenizer(br.readLine());
            k = Integer.parseInt(st.nextToken());
            if(k == 0)
                break;

            ary = new int[k];
            tmp = new int[k];
            check = new boolean[k];

            for(int i=0; i<k; i++)
                ary[i] = Integer.parseInt(st.nextToken());

            foo(0, 0);

            System.out.println(sb.toString());
        }
    }
}
