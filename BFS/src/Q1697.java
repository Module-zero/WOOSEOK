/*
숨바꼭질

https://www.acmicpc.net/problem/1697
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-22
 * Time: 오후 5:55
 */

public class Q1697
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        boolean[] check = new boolean[100001];

        Queue<int[]> queue = new LinkedList<>();
        int cnt = 0;

        queue.add(new int[]{N, cnt});
        check[N] = true;

        while(!queue.isEmpty())
        {
            int[] nums = queue.peek();

            // 큐에 넣을 때의 cnt가 현재 cnt와 같을 때까지
            while(nums[1] == cnt)
            {
                queue.poll();

                // nums[0]에는 현재 위치가 저장되어 있다.
                int location = nums[0];
                if(location == K)
                {
                    System.out.println(cnt);
                    return;
                }

                if(location+1 <= 100000 && !check[location+1])
                {
                    check[location + 1] = true;
                    queue.add(new int[]{location + 1, cnt + 1});
                }
                if(location-1 >= 0 && !check[location-1])
                {
                    check[location - 1] = true;
                    queue.add(new int[]{location - 1, cnt + 1});
                }
                if(location*2 <= 100000 && !check[location*2])
                {
                    check[location * 2] = true;
                    queue.add(new int[]{location * 2, cnt + 1});
                }

                nums = queue.peek();
            }

            cnt++;
        }
    }
}
