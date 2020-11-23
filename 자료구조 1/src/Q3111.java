/*
검열

https://www.acmicpc.net/problem/3111
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-23
 * Time: 오후 7:35
 */

public class Q3111
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String A = br.readLine();
        String T = br.readLine();

        Stack<int[]> front = new Stack<>();
        Stack<int[]> back = new Stack<>();

        int len = T.length();
        int fIndex = 0;
        int bIndex = len - 1;
        // true : 앞에서부터, false : 뒤에서부터
        boolean isFrontTurn = true;

        for(int i=0; i<len; i++)
        {
            // 앞에서부터
            if(isFrontTurn)
            {
                char ch = T.charAt(fIndex);

                int stackId;
                if(!front.isEmpty())
                    stackId = front.peek()[1];
                else
                    stackId = -1;

                // 차례인 정답 문자와 같으면 조건 검사
                if(ch == A.charAt(stackId + 1))
                {
                    // 마지막 문자면 스택에서 삭제
                    if(stackId + 1 == A.length() - 1)
                    {
//                        System.out.println(ch + " : " + (stackId + 1) + " : " + (A.length() - 1));
                        for(int k=0; k<A.length()-1; k++)
                            front.pop();

                        isFrontTurn = false;
                    }
                    // 마지막 문자가 아닌 다음 문자면 스택에 저장
                    else
                        front.add(new int[]{fIndex, stackId + 1});
                }
                // 다음 문자와 다르면 -1로 저장
                else
                {
                    if(ch == A.charAt(0))
                        front.add(new int[]{fIndex, 0});
                    else
                        front.add(new int[]{fIndex, -1});
                }

                fIndex++;
            }
            else
            {
                char ch = T.charAt(bIndex);

                int stackId;
                if(!back.isEmpty())
                    stackId = back.peek()[1];
                else
                    stackId = A.length();

                System.out.println(ch + " : " + stackId);
                // 다음 문자 순번과 같으면 조건 검사
                if(ch == A.charAt(stackId - 1))
                {
                    // 첫 번째 문자와 같으면 삭제
                    if(stackId - 1 == 0)
                    {
                        for(int k=0; k<A.length()-1; k++)
                            back.pop();

                        isFrontTurn = true;
                    }
                    // 첫 번째 문자가 아니면 스택에 저장
                    else
                        back.add(new int[]{bIndex, stackId - 1});
                }
                // 다음 문자와 다르면 A.length()로 저장
                else
                {
                    if(ch == A.charAt(A.length() - 1))
                        back.add(new int[]{bIndex, A.length() - 1});
                    else
                        back.add(new int[]{bIndex, A.length()});
                }

                bIndex--;
            }
        }

        while(!front.isEmpty())
        {
            int[] tmp = front.pop();

            // 삭제될 가능성이 없는 문자면 인덱스 범위를 벗어날 수 있기에 변경
            if(tmp[1] == -1)
            {
                tmp[1] = A.length();
                back.add(tmp);
            }
            else
            {
                int stackId;
                if(!back.isEmpty())
                    stackId = back.peek()[1];
                else
                    stackId = A.length();

                // 다음 순번의 문자와 같으면
                if(stackId - 1 == tmp[1])
                {
                    // 첫 번째 문자와 같으면 삭제
                    if(stackId - 1 == 0)
                    {
                        for(int k = 0; k < A.length() - 1; k++)
                            back.pop();
                    }
                    // 첫 번째 문자가 아니면 저장
                    else
                        back.add(tmp);
                }
                // 다음 순번의 문자와 다르면
                else
                    back.add(new int[]{tmp[0], A.length()});
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!back.isEmpty())
        {
            sb.append(T.charAt(back.pop()[0]));
        }

        System.out.println(sb.toString());
    }
}
