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

        int sum = A + B + C;

        Queue<int[]> queue = new LinkedList<>();
        boolean[][] check = new boolean[1001][1001];
        queue.add(new int[]{A, B});
        check[A][B] = true;
        check[B][A] = true;

        while(!queue.isEmpty())
        {
            int[] tmp = queue.poll();
            int a = tmp[0];
            int b = tmp[1];
            int c = sum - a - b;

            int[] ary = {a, b, c};

            for(int i=0; i<3; i++)
            {
                for(int j=0; j<3; j++)
                {
                    if(ary[i] < ary[j])
                    {
                        if(!check[ary[i]][ary[j]])
                        {
                            int ary2[] = {a, b, c};
                            ary2[i] = ary[i] + ary[i];
                            ary2[j] = ary[j] - ary[i];
                            check[ary2[i]][ary2[j]] = true;
                            queue.add(new int[]{ary2[i], ary2[j]});
                        }
                    }
                }
            }
        }

        if(check[sum / 3][sum / 3])
            System.out.println(1);
        else
            System.out.println(0);
    }
}
