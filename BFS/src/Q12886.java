/*
돌 그룹

https://www.acmicpc.net/problem/12886
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
 * Date: 2020-10-28
 * Time: 오후 10:23
 */

public class Q12886
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        if((A + B + C) % 3 != 0)
        {
            System.out.println(0);
            return;
        }

        // 이미 같으면 종료
        if(A == B && B == C)
        {
            System.out.println(1);
            return;
        }

        int sum = A + B + C;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[1501][1501];
        queue.add(new int[]{A, B});
        check[A][B] = true;
        check[B][A] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            int a = tmp[0];
            int b = tmp[1];

            int[] target1 = {a, a, b};
            int[] target2 = {b, sum - a - b, sum - a - b};

            for(int i=0; i<3; i++)
            {
                int target3 = sum - target1[i] - target2[i];

                int min = Integer.min(Integer.min(target1[i], target2[i]), target3);
                int max = Integer.max(Integer.max(target1[i], target2[i]), target3);

                max = max - min;
                min = min + min;

                if(min == max)
                {
                    System.out.println(1);
                    return;
                }

                if(!check[min][max])
                {
                    check[min][max] = true;
                    check[max][min] = true;
                    queue.add(new int[]{min, max});
                }
            }
        }

        System.out.println(0);
    }
}
