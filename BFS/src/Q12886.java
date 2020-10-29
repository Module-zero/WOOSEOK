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

        if((A+B+C)%3 != 0)
        {
            System.out.println("0");
            return;
        }

        // 셋 다 같은 수가 되어야 됨
        int target = (A+B+C)/3;

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A, B, C});

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            int a = tmp[0];
            int b = tmp[1];
            int c = tmp[2];

            // 답을 찾았으면 종료
            if(a == target && b == target && c == target)
            {
                return;
            }
        }
    }
}
