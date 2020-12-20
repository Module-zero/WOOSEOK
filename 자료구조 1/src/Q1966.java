/*
프린터 큐

https://www.acmicpc.net/problem/1966
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-20
 * Time: 오후 8:37
 */

public class Q1966
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int tc = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        while(tc-- > 0)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            Queue<int[]> queue = new LinkedList<>();
            // 중요도 따로 내림차순으로 저장
            PriorityQueue<Integer> gravity = new PriorityQueue<>();

            // 큐에 차례대로 넣는다.
            st = new StringTokenizer(br.readLine());
            for(int i=0; i<N; i++)
            {
                int num = Integer.parseInt(st.nextToken());
                queue.add(new int[]{num, i});
                gravity.add(-num);
            }

            int max = -gravity.poll();
            int cnt = 1;
            while(!queue.isEmpty())
            {
                // [0] : 중요도, [1] : 순번
                int[] num = queue.peek();

                // 중요도가 제일 높은 수면 인쇄
                if(num[0] == max)
                {
                    // M번째 수면 순서 출력 후 종료
                    if(num[1] == M)
                    {
                        sb.append(cnt).append('\n');
                        break;
                    }

                    queue.poll();
                    // 최댓값 갱신
                    max = -gravity.poll();
                    cnt++;
                }
                // 아니면 맨 뒤로
                else
                    queue.add(queue.poll());
            }
        }

        System.out.print(sb.toString());
    }
}
