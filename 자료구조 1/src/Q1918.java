/*
후위 표기식

https://www.acmicpc.net/problem/1918
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-06
 * Time: 오후 9:43
 */

public class Q1918
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();

        StringBuilder sb = new StringBuilder();
        Stack<Character> opStack = new Stack<>();
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            switch(ch)
            {
                case '+':
                case '-':
                    // 스택에 연산자가 있을 경우
                    while(!opStack.isEmpty())
                    {
                        char op = opStack.peek();

                        if(op == '+' || op == '-' || op == '*' || op == '/')
                        {
                            opStack.pop();
                            sb.append(op);
                        }
                        else
                            break;
                    }

                    opStack.push(ch);
                    break;
                case '*':
                case '/':
                    if(!opStack.isEmpty())
                    {
                        char op = opStack.peek();

                        if (op == '*' || op == '/')
                        {
                            opStack.pop();
                            sb.append(op);
                        }
                    }

                    opStack.push(ch);
                    break;
                case '(':
                    opStack.push(ch);
                    break;
                case ')':
                    while(true)
                    {
                        char op = opStack.pop();
                        if(op == '(')
                            break;

                        sb.append(op);
                    }
                    break;
                // 알파벳일 경우
                default:
                    sb.append(ch);

                    break;
            }
        }

        while(!opStack.isEmpty())
            sb.append(opStack.pop());

        System.out.println(sb.toString());
    }
}
