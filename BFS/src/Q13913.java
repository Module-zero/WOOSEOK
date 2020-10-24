/*
숨바꼭질 4

https://www.acmicpc.net/problem/13913
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 8:19
 */

public class Q13913
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        Queue<int[]> queue = new LinkedList<>();
        boolean[] check = new boolean[100001];
        int[] prev = new int[100001];
        int cnt = 0;

        queue.add(new int[]{N, cnt});
        check[N] = true;
        prev[N] = -1;

        while(!queue.isEmpty())
        {
            // 큐에서 꺼내기 전에 값을 본다.
            int[] nums = queue.peek();

            // 현재 시간대의 가능한 위치를 큐에서 모두 꺼낼 때까지 반복
            while(nums[1] == cnt)
            {
                // 큐에서 꺼낸다.
                queue.poll();

                int location = nums[0];
                // 찾았으면 출력하고 종료
                if(location == K)
                {
                    sb.append(cnt + "\n");

                    int route = K;

                    Stack<Integer> stack = new Stack<>();
                    // 시작점까지의 경로를 스택에 넣는다.
                    while(route != -1)
                    {
                        stack.push(route);
                        route = prev[route];
                    }

                    while(!stack.isEmpty())
                        sb.append(stack.pop() + " ");

                    System.out.println(sb.toString());
                    return;
                }

                if(location + 1 <= 100000 && !check[location + 1])
                {
                    queue.add(new int[]{location + 1, cnt + 1});
                    check[location + 1] = true;
                    prev[location + 1] = location;
                }
                if(location - 1 >= 0 && !check[location - 1])
                {
                    queue.add(new int[]{location - 1, cnt + 1});
                    check[location - 1] = true;
                    prev[location - 1] = location;
                }
                if(location * 2 <= 100000 && !check[location * 2])
                {
                    queue.add(new int[]{location * 2, cnt + 1});
                    check[location * 2] = true;
                    prev[location * 2] = location;
                }

                nums = queue.peek();
            }

            cnt++;
        }
    }
}
