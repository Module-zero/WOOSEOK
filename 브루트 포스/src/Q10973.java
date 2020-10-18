/*
이전 순열

https://www.acmicpc.net/problem/1097ㅈ3
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-10-18
 * Time: 오후 7:01
 */

public class Q10973
{
    static int[] ary;
    static StringBuilder sb = new StringBuilder().append("-1");

    public static void swap(int[] ary, int index1, int index2)
    {
        int tmp = ary[index1];
        ary[index1] = ary[index2];
        ary[index2] = tmp;
    }

    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        ary = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            ary[i] = Integer.parseInt(st.nextToken());

        int index = 0;
        for(int i=1; i<N; i++)
        {
            if(ary[i] < ary[i-1])
                index = i;
        }

        if(index != 0)
        {
            int maxIndex = 0;
            for (int i = index; i < N; i++)
            {
                if (ary[i] < ary[index - 1])
                    maxIndex = i;
            }

            swap(ary, index-1, maxIndex);

            sb = new StringBuilder();
            for(int i=0; i<index; i++)
                sb.append(ary[i] + " ");

            for(int i=N-1; i>=index; i--)
                sb.append(ary[i] + " ");
        }

        System.out.println(sb.toString());
    }
}
