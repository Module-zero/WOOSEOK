/*
-2진수

문제
-2진법은 부호 없는 2진수로 표현이 된다. 2진법에서는 20, 21, 22, 23이 표현 되지만 -2진법에서는 (-2)0 = 1, (-2)1 = -2, (-2)2 = 4, (-2)3 = -8을 표현한다. 10진수로 1부터 표현하자면 1, 110, 111, 100, 101, 11010, 11011, 11000, 11001 등이다.

10진법의 수를 입력 받아서 -2진수를 출력하는 프로그램을 작성하시오.

입력
첫 줄에 10진법으로 표현된 수 N(-2,000,000,000≤N≤2,000,000,000)이 주어진다.

출력
-2진법 수를 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-07
 * Time: 오후 11:15
 */

public class Q2089
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        if(N == 0)
            System.out.println("0");
        else
        {
            StringBuilder sb = new StringBuilder();
            Stack<Integer> stack = new Stack<>();

            while (N != 0)
            {
                int rem = N % -2;
                if (rem < 0)
                    rem = -rem;

                stack.push(rem);

                if (N < 0)
                    N = (N - rem) / -2;
                else
                    N = N / -2;
            }

            while (!stack.isEmpty())
            {
                sb.append(stack.pop());
            }

            System.out.println(sb.toString());
        }
    }
}
