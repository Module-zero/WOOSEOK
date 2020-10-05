/*
문제
정수를 저장하는 스택을 구현한 다음, 입력으로 주어지는 명령을 처리하는 프로그램을 작성하시오.

명령은 총 다섯 가지이다.

push X: 정수 X를 스택에 넣는 연산이다.
pop: 스택에서 가장 위에 있는 정수를 빼고, 그 수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
size: 스택에 들어있는 정수의 개수를 출력한다.
empty: 스택이 비어있으면 1, 아니면 0을 출력한다.
top: 스택의 가장 위에 있는 정수를 출력한다. 만약 스택에 들어있는 정수가 없는 경우에는 -1을 출력한다.
입력
첫째 줄에 주어지는 명령의 수 N (1 ≤ N ≤ 10,000)이 주어진다. 둘째 줄부터 N개의 줄에는 명령이 하나씩 주어진다. 주어지는 정수는 1보다 크거나 같고, 100,000보다 작거나 같다. 문제에 나와있지 않은 명령이 주어지는 경우는 없다.

출력
출력해야하는 명령이 주어질 때마다, 한 줄에 하나씩 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-05
 * Time: 오후 3:46
 */

public class Q10828
{
    private final static int SIZE = 10000;

    static class mStack
    {
        private int[] data;
        private int top;

        public mStack()
        {
            data = new int[SIZE];
            top = -1;
        }

        void push(int X)
        {
            data[++top] = X;
        }

        int pop()
        {
            return (top == -1) ? -1 : data[top--];
        }

        int size()
        {
            return top + 1;
        }

        int empty()
        {
            return (top == -1) ? 1 : 0;
        }

        int top()
        {
            return (top == -1) ? -1 : data[top];
        }
    }

    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        mStack stack = new mStack();

        while(N-- > 0)
        {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();

            switch(str)
            {
                case "push":
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;
                case "pop":
                    System.out.println(stack.pop());
                    break;
                case "size":
                    System.out.println(stack.size());
                    break;
                case "empty":
                    System.out.println(stack.empty());
                    break;
                case "top":
                    System.out.println(stack.top());
                    break;
                default:
                    break;
            }
        }
    }
}
