/*
과제는 끝나지 않아!

https://www.acmicpc.net/problem/17952
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-30
 * Time: 오후 10:57
 */

public class Q17952
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int ans = 0;
        Stack<int[]> stack = new Stack<>();
        for(int i=0; i<N; i++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int num = Integer.parseInt(st.nextToken());
            if(num == 0)
            {
                if(!stack.isEmpty())
                {
                    // [0] : 과제 점수, [1] : 남은 시간
                    int[] cur = stack.pop();
                    // 과제를 한다.
                    cur[1]--;

                    if(cur[1] == 0)
                        ans += cur[0];
                    else
                        stack.add(cur);
                }
            }
            else
            {
                int A = Integer.parseInt(st.nextToken());
                int T = Integer.parseInt(st.nextToken());
                // 받자마자 과제를 함
                --T;

                if(T == 0)
                    ans += A;
                else
                    stack.add(new int[]{A, T});
            }
        }

        System.out.println(ans);
    }
}
