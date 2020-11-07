/*
에너지 모으기

https://www.acmicpc.net/problem/16198
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-11-07
 * Time: 오후 8:04
 */

public class Q16198
{
    static int N;
    static int max = Integer.MIN_VALUE;

    public static void foo(ArrayList<Integer> W, int sum)
    {
        int n = W.size();
        if(n == 2)
        {
            if(max < sum)
                max = sum;

            return;
        }

        // 첫 번째와 마지막은 제거할 수 없다.
        for(int i=1; i<n-1; i++)
        {
            int energy = W.get(i-1)*W.get(i+1);

            ArrayList<Integer> list = new ArrayList<>(W);
            list.remove(i);

            foo(list, sum + energy);
        }
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        ArrayList<Integer> W = new ArrayList<>();
        for(int i=0; i<N; i++)
            W.add(Integer.parseInt(st.nextToken()));

        foo(W, 0);

        System.out.println(max);
    }
}
