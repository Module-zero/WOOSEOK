/*
수 찾기

https://www.acmicpc.net/problem/1920
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2020-12-17
 * Time: 오후 3:34
 */

public class Q1920
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] A = new int[100001];
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A, 0, N);

        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<M; i++)
        {
            int num = Integer.parseInt(st.nextToken());
            boolean found = false;

            int left = 0;
            int right = N-1;

            while(left <= right)
            {
                int mid = (left + right) / 2;

                if(num < A[mid])
                    right = mid - 1;
                else if(num > A[mid])
                    left = mid + 1;
                else
                {
                    sb.append(1).append('\n');
                    left = mid + 1;
                    found = true;
                    break;
                }
            }

            if(!found)
                sb.append(0).append('\n');
        }

        System.out.print(sb.toString());
    }
}
