/*
카드게임

https://www.acmicpc.net/problem/10835
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
 * Date: 2021-02-07
 * Time: 오전 12:27
 */

public class Q10835
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Queue<Integer> left = new LinkedList<>();
        int max = 0;
        for(int i=0; i<N; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            if(max < num)
                max = num;

            left.add(num);
        }

        st = new StringTokenizer(br.readLine());
        Queue<Integer> right = new LinkedList<>();
        for(int i=0; i<N; i++)
            right.add(Integer.parseInt(st.nextToken()));

        int ans = 0;
        while(!left.isEmpty() && !right.isEmpty())
        {
            int l = left.peek();
            int r = right.peek();

            if(max <= r)
                right.poll();

            if(l > r)
                ans += right.poll();
            else
                left.poll();
        }

        System.out.println(ans);
    }
}
