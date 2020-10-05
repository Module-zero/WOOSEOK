/*
문제
문장이 주어졌을 때, 단어를 모두 뒤집어서 출력하는 프로그램을 작성하시오. 단, 단어의 순서는 바꿀 수 없다. 단어는 영어 알파벳으로만 이루어져 있다.

입력
첫째 줄에 테스트 케이스의 개수 T가 주어진다. 각 테스트 케이스는 한 줄로 이루어져 있으며, 문장이 하나 주어진다. 단어의 길이는 최대 20, 문장의 길이는 최대 1000이다. 단어와 단어 사이에는 공백이 하나 있다.

출력
각 테스트 케이스에 대해서, 입력으로 주어진 문장의 단어를 모두 뒤집어 출력한다.
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-05
 * Time: 오후 4:07
 */

public class Q9093
{
    public static void main(String[] args) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int T = Integer.parseInt(st.nextToken());

        while(T-- > 0)
        {
            String str = br.readLine();
            char[] cAry = str.toCharArray();
            StringBuilder sb = new StringBuilder();

            Stack stack = new Stack<>();

            int arySize = cAry.length;

            for(int i=0; i<arySize; i++)
            {
                if(cAry[i] == ' ')
                {
                    while(!stack.isEmpty())
                    {
                        sb.append(stack.pop());
                    }
                    sb.append(' ');
                }
                else
                    stack.push(cAry[i]);
            }

            while(!stack.isEmpty())
            {
                sb.append(stack.pop());
            }

            System.out.println(sb.toString());
        }
    }
}
