/*
오아시스 재결합

https://www.acmicpc.net/problem/3015
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-22
 * Time: 오후 6:10
 */

public class Q3015
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] height = new int[500001];
        for(int i=0; i<N; i++)
            height[i] = Integer.parseInt(br.readLine());

        long cnt = 0;
        // [0] : 키, [1] : 같은 키인 사람의 수
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<N; i++)
        {
            // 같은 사람의 수
            int number = 1;

            while(!stack.isEmpty())
            {
                int[] tmp = stack.peek();
                int h = tmp[0];

                // 앞 사람의 키가 자신보다 작으면 서로 볼 수 있으므로 cnt를 앞 사람과 키가 같은 사람의 수만큼 증가 후 스택에서 제거
                if(h < height[i])
                {
                    cnt += tmp[1];
                    stack.pop();
                }
                // 키가 같은 사람이면 제거하고 인원수 같은 키 인원만큼 증가
                else if(h == height[i])
                {
                    cnt += tmp[1];
                    number += tmp[1];
                    stack.pop();
                }
                else
                {
                    cnt++;
                    break;
                }
            }

            stack.push(new int[]{height[i], number});
        }

        System.out.println(cnt);
    }
}
