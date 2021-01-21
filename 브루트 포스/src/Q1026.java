/*
보물

https://www.acmicpc.net/problem/1026
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * Created by WOOSERK.
 * User: WOOSERK
 * Date: 2021-01-21
 * Time: 오후 11:37
 */

public class Q1026
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] A = new int[51];
        Integer[] B = new Integer[51];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            A[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++)
            B[i] = Integer.parseInt(st.nextToken());

        Arrays.sort(A, 0, N);
        Arrays.sort(B, 0, N, Collections.reverseOrder());

        int sum = 0;
        for(int i=0; i<N; i++)
            sum += A[i] * B[i];

        System.out.println(sum);
    }
}
