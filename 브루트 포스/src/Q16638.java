/*
괄호 추가하기 2

https://www.acmicpc.net/problem/16638
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-09
 * Time: 오전 1:12
 */

public class Q16638
{
    static int N;
    static int[] num = new int[10];
    static char[] op = new char[10];
    static boolean[] check = new boolean[10];
    static int max = Integer.MIN_VALUE;

    public static void foo(int id)
    {
        if(id >= N-1)
        {
            int sum = 0;
            int cur = 0;
            for(int i=0; i<N-1; i++)
            {
                if(op[i] == '+')
                {

                }
            }

            sum += cur;
            max = Integer.max(sum, max);

            return;
        }

        // 두 수가 괄호에 있지 않으면 괄호를 친다.
        if(!check[id])
        {
            check[id] = true;
            check[id+1] = true;

            int n1Tmp = num[id];
            int n2Tmp = num[id+1];
            char cTmp = op[id];
            switch(op[id])
            {
                case '+':
                    num[id] += num[id+1];
                    break;
                case '-':
                    num[id] -= num[id+1];
                    break;
                case '*':
                    num[id] *= num[id+1];
                    break;
            }
            op[id] = '+';
            num[id+1] = 0;

            foo(id+1);

            op[id] = cTmp;
            num[id] = n1Tmp;
            num[id+1] = n2Tmp;

            check[id] = false;
            check[id+1] = false;
        }

        foo(id+1);
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        String str = br.readLine();
        num[0] = str.charAt(0) - '0';
        for(int i=1; i<N; i+=2)
        {
            op[i] = str.charAt(i);
            num[i] = str.charAt(i+1) - '0';
        }

    }
}
