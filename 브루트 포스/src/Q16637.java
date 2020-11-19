/*
괄호 추가하기

https://www.acmicpc.net/problem/16637
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-12
 * Time: 오전 11:36
 */

public class Q16637
{
    static int N;
    static int[] ary = new int[10];
    static char[] oper = new char[10];
    static int max = Integer.MIN_VALUE;

    public static void foo(int index, boolean isChange)
    {
        if(index == N/2)
        {
            int sum = ary[0];
            for(int i=1; i<=N/2; i++)
            {
                switch(oper[i-1])
                {
                    case '+':
                        sum += ary[i];
                        break;
                    case '-':
                        sum -= ary[i];
                        break;
                    case '*':
                        sum *= ary[i];
                        break;
                    case '/':
                        sum /= ary[i];
                        break;
                }
            }

            if(sum > max)
                max = sum;

            return;
        }

        // 겹괄호는 쓸 수 없다.
        if(isChange)
        {
            foo(index + 1, !isChange);
            return;
        }

        int tmp = ary[index];

        switch(oper[index])
        {
            case '+':
                ary[index] += ary[index+1];
                break;
            case '-':
                ary[index] -= ary[index+1];
                break;
            case '*':
                ary[index] *= ary[index+1];
                break;
            case '/':
                ary[index] /= ary[index+1];
                break;
        }

        int tmp2 = ary[index+1];
        char opTmp = oper[index];
        ary[index+1] = 0;
        oper[index] = '+';
        foo(index+1, true);

        ary[index] = tmp;
        ary[index+1] = tmp2;
        oper[index] = opTmp;
        foo(index+1, false);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        for(int i=0; i<N; i++)
        {
            if(i%2 == 0)
                ary[i/2] = str.charAt(i) - '0';
            else
                oper[i/2] = str.charAt(i);
        }

        foo(0, false);

        System.out.println(max);
    }
}
