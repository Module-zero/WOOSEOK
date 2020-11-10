/*
압축

https://www.acmicpc.net/problem/1662
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-10
 * Time: 오후 5:24
 */

public class Q1662
{
    static class Save
    {
        char ch;
        int len;

        public Save(char ch, int len)
        {
            this.ch = ch;
            this.len = len;
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String S = br.readLine();

        Stack<Save> stack = new Stack<>();

        for(int i=0; i<S.length(); i++)
        {
            char ch = S.charAt(i);

            // 닫은 괄호가 나오면 문자열을 생성한다.
            if(ch == ')')
            {
                int cnt = 0;
                Save cur = stack.pop();

                // 여는 괄호를 만날 때까지 글자 수를 센다.
                while(cur.ch != '(')
                {
                    cnt += cur.len;
                    cur = stack.pop();
                }

                // cnt개의 문자열을 괄호 앞의 숫자만큼 반복 ex) 2(22)일 때, 2개의 문자열을 2만큼 반복 -> 4
                int repeat = stack.pop().ch - '0';
                cnt *= repeat;

                // 길이를 저장한다.
                stack.push(new Save(' ', cnt));
            }
            // 탐색하면서 스택에 넣을 때의 문자의 길이는 1
            else
                stack.push(new Save(ch, 1));
        }

        int ans = 0;
        while(!stack.isEmpty())
        {
            Save cur = stack.pop();
            ans += cur.len;
        }

        System.out.println(ans);
    }
}
