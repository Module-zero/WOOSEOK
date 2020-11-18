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

        int sum = A + B + C;
        if(sum % 3 != 0)
        {
            System.out.println(0);
            return;
        }

        boolean[][] check = new boolean[1501][1501];

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{A, B});
        check[A][B] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();

            int[] a = {tmp[0], tmp[1], sum - tmp[0] - tmp[1]};

            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(a[i] < a[j])
                    {
                        int[] b = {tmp[0], tmp[1], sum - tmp[0] - tmp[1]};
                        b[i] += a[i];
                        b[j] -= a[i];

                        if(b[i] == b[j] && b[i] == (sum - b[i] - b[j]))
                        {
                            System.out.println(1);
                            return;
                        }

                        if(!check[b[i]][b[j]])
                        {
                            queue.add(new int[]{b[i], b[j]});
                            check[b[i]][b[j]] = true;
                        }
                    }
                }
            }
        }

        if(check[sum/3][sum/3])
            System.out.println(1);
        else
            System.out.println(0);
    }
}
