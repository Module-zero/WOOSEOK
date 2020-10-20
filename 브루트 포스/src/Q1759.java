/*
암호 만들기

https://www.acmicpc.net/problem/1759
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 9:22
 */

public class Q1759
{
    static int L;
    static int C;
    static char[] ary;
    static char[] tmp;
    static boolean[] check;
    static StringBuilder sb = new StringBuilder();

    public static void foo(int index, int start, int ja, int mo)
    {
        if(index == L)
        {
            if(ja >= 2 && mo >= 1)
            {
                for (int i = 0; i < L; i++)
                    sb.append(tmp[i]);

                sb.append("\n");
            }

            return;
        }

        for(int i=start; i<C; i++)
        {
            if(check[i])
                continue;

            switch(ary[i])
            {
                case 'a':
                case 'e':
                case 'i':
                case 'o':
                case 'u':
                    check[i] = true;
                    tmp[index] = ary[i];
                    foo(index+1, i+1, ja, mo+1);
                    check[i] = false;
                    break;
                default:
                    check[i] = true;
                    tmp[index] = ary[i];
                    foo(index+1, i+1, ja+1, mo);
                    check[i] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        ary = new char[C];
        tmp = new char[L];
        check = new boolean[C];

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<C; i++)
            ary[i] = st.nextToken().charAt(0);

        Arrays.sort(ary);

        foo(0, 0, 0, 0);

        System.out.print(sb.toString());
    }
}
