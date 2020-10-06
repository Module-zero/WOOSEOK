/*
후위 표기식2

문제
후위 표기식과 각 피연산자에 대응하는 값들이 주어져 있을 때, 그 식을 계산하는 프로그램을 작성하시오.

입력
첫째 줄에 피연산자의 개수(1 ≤ N ≤ 26) 가 주어진다. 그리고 둘째 줄에는 후위 표기식이 주어진다. (여기서 피연산자는 A~Z의 영대문자이며, A부터 순서대로 N개의 영대문자만이 사용되며, 길이는 100을 넘지 않는다) 그리고 셋째 줄부터 N+2번째 줄까지는 각 피연산자에 대응하는 값이 주어진다. (3번째 줄에는 A에 해당하는 값, 4번째 줄에는 B에 해당하는값 , 5번째 줄에는 C ...이 주어진다, 그리고 피연산자에 대응 하는 값은 정수이다)

출력
계산 결과를 소숫점 둘째 자리까지 출력한다.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-06
 * Time: 오후 3:38
 */

public class Q1935
{
    public static void main(String[] args)
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        try
        {
            int N = Integer.parseInt(br.readLine());

            String str = br.readLine();
            char[] cAry = str.toCharArray();
            int len = cAry.length;

            Stack<Double> stack = new Stack<>();
            int[] ary = new int[100];

            for (int i = 0; i < len; i++)
            {
                char ch = cAry[i];

                if (ch >= 'A' && ch <= 'Z')
                {
                    // 입력받지 않았던 피연산자면 배열에 입력한다.
                    if (ary[ch] == 0)
                        ary[ch] = Integer.parseInt(br.readLine());

                    stack.push((double) ary[ch]);
                } else
                {
                    double d1 = stack.pop();
                    double d2 = stack.pop();

                    switch (ch)
                    {
                        case '+':
                            stack.push(d2 + d1);
                            break;
                        case '-':
                            stack.push(d2 - d1);
                            break;
                        case '*':
                            stack.push(d2 * d1);
                            break;
                        case '/':
                            stack.push(d2 / d1);
                            break;
                        default:
                    }
                }
            }

            System.out.printf("%.2f", stack.pop());
        }
        catch(Exception e) {}
    }
}
