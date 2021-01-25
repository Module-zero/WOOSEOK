/*
괄호의 값

https://www.acmicpc.net/problem/2504
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-25
 * Time: 오후 6:50
 */

public class Q2504
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int len = str.length();
        Stack<Character> stack = new Stack<>();
        Stack<Integer> value = new Stack<>();
        for(int i=0; i<len; i++)
        {
            char ch = str.charAt(i);

            if(ch == ')')
            {
                if(stack.isEmpty() || stack.peek() != '(')
                {
                    System.out.println(0);
                    return;
                }
                else
                {
                    stack.pop();

                    int cur = 0;
                    while(true)
                    {
                        int v = value.pop();
                        if(v == 1)
                            break;
                        cur += v;
                    }

                    if(cur == 0)
                        cur = 2;
                    else
                        cur *= 2;

                    value.add(cur);
                }
            }
            else if(ch == ']')
            {
                if(stack.isEmpty() || stack.peek() != '[')
                {
                    System.out.println(0);
                    return;
                }
                else
                {
                    stack.pop();

                    int cur = 0;
                    while(true)
                    {
                        int v = value.pop();
                        if(v == 1)
                            break;
                        cur += v;
                    }

                    if(cur == 0)
                        cur = 3;
                    else
                        cur *= 3;
                    value.add(cur);
                }
            }
            else
            {
                stack.add(ch);
                value.add(1);
            }
        }

        if(!stack.isEmpty())
        {
            System.out.println(0);
            return;
        }

        int sum = 0;
        while(!value.isEmpty())
            sum += value.pop();

        System.out.println(sum);
    }
}
