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
        int bracketCnt = 0;
        for(int i=0; i<str.length(); i++)
        {
            char ch = str.charAt(i);

            switch(ch)
            {
                case '+':
                case '-':
                    opStack.push(ch);
                    break;
                case '*':
                case '/':
                    opStack.push(ch);
                    break;
                case '(':
                    opStack.push(ch);

                    bracketCnt++;
                    break;
                case ')':
                    opStack.push(ch);

                    sb.append(opStack.pop());
                    bracketCnt--;
                    break;
                // 알파벳일 경우
                default:
                    sb.append(ch);

                    // 스택에 연산자가 있을 경우
                    if(!opStack.isEmpty())
                    {
                        char op = opStack.pop();
                        if(op == '*' || op == '/')
                        {

                        }
                    }
                    break;
            }
        }

        while(!opStack.isEmpty())
            sb.append(opStack.pop());

        System.out.println(sb.toString());
    }
}
